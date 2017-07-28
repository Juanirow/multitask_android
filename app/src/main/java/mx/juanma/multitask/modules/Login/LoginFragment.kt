package mx.juanma.multitask.modules.Login

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.R


/**
 * Created by Juancho on 28/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginFragment: Fragment() {

    companion object {
        @JvmStatic fun getInstance(): LoginFragment {
            val fragment = LoginFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.fragment_login, container, false)
        return view!!
    }
}