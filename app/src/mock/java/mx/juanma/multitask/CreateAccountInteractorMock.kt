package mx.juanma.multitask

import android.os.Handler
import mx.juanma.multitask.modules.CreateAccount.ICreateAccountInteractor


/**
 * Created by Juancho on 02/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountInteractorMock: ICreateAccountInteractor {

    val handler = Handler()

    override fun createAccount(email: String, password: String,
                               listener: ICreateAccountInteractor.Callback?) {
        handler.postDelayed({
            if (password == "123456") {
                listener?.onCreateAccountServerError()
            } else {
                if (password == "223456") {
                    listener?.onUserAlreadyInUse()
                } else {
                    listener?.onCreateAccountSuccess()
                }
            }

        }, 2000)
    }
}