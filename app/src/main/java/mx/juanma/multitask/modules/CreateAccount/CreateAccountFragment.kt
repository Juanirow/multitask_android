package mx.juanma.multitask.modules.CreateAccount

import android.app.Fragment


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


}