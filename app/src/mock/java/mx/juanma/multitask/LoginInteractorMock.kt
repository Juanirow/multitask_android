package mx.juanma.multitask

import android.os.Handler
import mx.juanma.multitask.modules.Login.ILoginInteractor


/**
 * Created by Juancho on 30/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginInteractorMock: ILoginInteractor {

    val mHandler = Handler()

    override fun signUp(email: String, password: String, listener: ILoginInteractor.Callback?) {

        val runnable = Runnable {
            if(password == "123456") {
                listener?.onLoginServerError()
            }
            else {
                listener?.onWrongCredentials()
            }
        }
        mHandler.postDelayed(runnable, 2000)
    }
}