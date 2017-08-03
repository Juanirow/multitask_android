package mx.juanma.multitask.modules.CreateAccount

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.database.FirebaseDatabase
import mx.juanma.multitask.models.User


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountInteractor: ICreateAccountInteractor {

    override fun createAccount(email: String, password: String,
                               listener: ICreateAccountInteractor.Callback?) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,
                password).addOnCompleteListener {
            task ->
            if(task.isSuccessful) {
                val userId = task.result.user.uid
                val database = FirebaseDatabase.getInstance()
                val ref = database.getReference("users")
                val user = User(userId, email)
                ref.child(userId).setValue(user)
                listener?.onCreateAccountSuccess()
            }
            else {
                try {
                    if(task.exception != null) {
                        throw task.exception!!
                    }
                    else {
                        listener?.onCreateAccountServerError()
                    }
                }
                catch(ex: FirebaseAuthUserCollisionException){
                    listener?.onUserAlreadyInUse()
                }
            }
        }
    }
}