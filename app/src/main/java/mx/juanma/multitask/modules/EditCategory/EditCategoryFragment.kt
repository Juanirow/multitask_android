package mx.juanma.multitask.modules.EditCategory

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.R


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryFragment: Fragment() {
    
    companion object {
        @JvmStatic fun getInstance(): EditCategoryFragment {
            val fragment = EditCategoryFragment()
            fragment.retainInstance = true
            return fragment
         }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_edit_category, container, false)
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //TODO implement Presenter
        super.onActivityCreated(savedInstanceState)
    }
}