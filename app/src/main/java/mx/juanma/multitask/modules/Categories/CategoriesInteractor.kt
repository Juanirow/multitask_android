package mx.juanma.multitask.modules.Categories

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 09/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesInteractor: ICategoriesInteractor {
    val TAG = "CategoriesInteractor"

    override fun getUserCategories(callback: ICategoriesInteractor.Callback?) {
        val user = FirebaseAuth.getInstance().currentUser
        if(user == null) {
            callback?.onExpiredSession()
            return
        }
        val ref = FirebaseDatabase.getInstance().getReference("category/${user.uid}")
        ref.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                Log.d(TAG, "onCancelled: ")
            }

            override fun onDataChange(p0: DataSnapshot?) {
                val categories = ArrayList<Category>()
                p0?.children!!.mapTo(categories) { it.getValue(Category::class.java) }
                callback?.onLoadCategories(categories)
            }
        })
    }

    override fun onDeleteCategory(id: String?, callback: ICategoriesInteractor.DeleteCallback?) {
        val user = FirebaseAuth.getInstance().currentUser
        if(user == null) {
            callback?.onExpiredSessionDuringDelete()
            return
        }
        val ref = FirebaseDatabase.getInstance().getReference("category/${user.uid}/$id")
        ref.removeValue { _, _ -> callback?.onDeleteSuccess() }
    }
}