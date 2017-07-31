package mx.juanma.multitask.modules.Login

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


/**
 * Created by Juancho on 30/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginInteractor: ILoginInteractor {

    val TAG = "LoginInteractor"

    override fun signUp(email: String, password: String, listener: ILoginInteractor.Callback?) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    task ->
                    if(task.isSuccessful) {
                        listener?.onLoginSuccessful()
                    }
                    else {
                        try {
                            task.exception
                        }
                        catch(e: FirebaseAuthInvalidCredentialsException) {
                            Log.d(TAG, "signUp: ${e.errorCode}")
                            listener?.onWrongCredentials()
                        }
                        catch(e: FirebaseAuthInvalidUserException) {
                            Log.d(TAG, "signUp: ${e.errorCode}")
                            listener?.onWrongCredentials()
                        }
                        catch(e: Exception) {
                            listener?.onLoginServerError()
                        }
                    }
                }
    }
}