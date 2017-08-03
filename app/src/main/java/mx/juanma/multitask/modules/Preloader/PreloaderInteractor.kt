package mx.juanma.multitask.modules.Preloader

import com.google.firebase.auth.FirebaseAuth


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class PreloaderInteractor: IPreloaderInteractor {

    override fun verifySession(listener: IPreloaderInteractor.Callback?) {
        val user = FirebaseAuth.getInstance().currentUser
        if(user == null) {
            listener?.onInActiveSession()
        }
        else {
            listener?.onActiveSession()
        }
    }
}