package mx.juanma.multitask.modules.Categories

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.R


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
}