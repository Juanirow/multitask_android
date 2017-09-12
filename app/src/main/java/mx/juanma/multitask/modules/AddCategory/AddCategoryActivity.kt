package mx.juanma.multitask.modules.AddCategory

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import mx.juanma.multitask.R

class AddCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        this.fragmentManager.beginTransaction()
                .add(R.id.content_add_category, AddCategoryFragment.getInstance())
                .commit()
    }

}
