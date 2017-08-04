package mx.juanma.multitask.modules.Main

import com.google.firebase.auth.FirebaseAuth


/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class MainInteractor: IMainInteractor {

    override fun logout() {
        FirebaseAuth.getInstance().signOut()
    }
}