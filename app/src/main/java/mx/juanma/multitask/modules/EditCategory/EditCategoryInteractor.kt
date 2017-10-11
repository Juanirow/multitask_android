package mx.juanma.multitask.modules.EditCategory

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryInteractor: IEditCategoryInteractor {

    override fun updateCategory(id: String, category: Category, callback: IEditCategoryInteractor.Callback?) {
        val reference = FirebaseDatabase.getInstance().reference.child("category")
        val user = FirebaseAuth.getInstance().currentUser
        if(user == null) {
            callback?.onSessionExpired()
            return
        }
        val userId = user.uid
        category.id = id
        reference.child(userId).child(id).setValue(category, DatabaseReference.CompletionListener
        { databaseError, databaseReference ->
            if (databaseError != null) {
                callback?.onInternalServerError()
            } else {
                callback?.onCategoryUpdate()
            }
        })
    }
}