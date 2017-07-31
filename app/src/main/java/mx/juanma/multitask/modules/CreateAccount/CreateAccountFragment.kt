package mx.juanma.multitask.modules.CreateAccount

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.R


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountFragment: Fragment() {

    companion object {
        @JvmStatic fun getInstance(): CreateAccountFragment {
            val fragment = CreateAccountFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)
        return view
    }


}