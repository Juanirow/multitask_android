package mx.juanma.multitask.modules.AddCategory

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryInteractor: IAddCategoryInteractor {

    override fun addNewCategory(category: Category, callback: IAddCategoryInteractor.Callback?) {
        val reference = FirebaseDatabase.getInstance().reference.child("category")
        val user = FirebaseAuth.getInstance().currentUser
        if(user == null) {
            callback?.onSessionExpired()
            return
        }
        val userId = user.uid
        val key = reference.child(userId).push().key
        reference.child(userId).child(key).setValue(category, DatabaseReference.CompletionListener
                { databaseError, databaseReference ->
                    if (databaseError != null) {
                        callback?.onInternalServerError()
                    } else {
                        callback?.onCategoryAdded()
                    }
                })
    }
}