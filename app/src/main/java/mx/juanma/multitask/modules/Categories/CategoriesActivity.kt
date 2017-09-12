package mx.juanma.multitask.modules.Categories

import android.app.Activity
import android.os.Bundle
import mx.juanma.multitask.R


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        this.fragmentManager.beginTransaction()
                .add(R.id.content_categories, CategoriesFragment.getInstance())
                .commit()
    }
}