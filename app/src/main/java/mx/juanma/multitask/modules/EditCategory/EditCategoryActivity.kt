package mx.juanma.multitask.modules.EditCategory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mx.juanma.multitask.R


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_category)

        this.fragmentManager.beginTransaction()
                .add(R.id.content_fragment, EditCategoryFragment.getInstance())
                .commit()
    }
}