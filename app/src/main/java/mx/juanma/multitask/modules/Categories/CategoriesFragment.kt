package mx.juanma.multitask.modules.Categories

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_categories.*
import mx.juanma.multitask.Constants
import mx.juanma.multitask.R
import mx.juanma.multitask.modules.AddCategory.AddCategoryActivity


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesFragment: Fragment() {

    companion object {
        @JvmStatic fun getInstance(): CategoriesFragment {
            val fragment = CategoriesFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.fragment_categories, container, false)
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.fabAddCategory.setOnClickListener {
            //TODO change to mvp
            val intent = Intent(this.activity, AddCategoryActivity::class.java)
            startActivityForResult(intent, Constants.REQUEST_ADD_CATEGORY)
        }
    }
}