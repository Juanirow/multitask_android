package mx.juanma.multitask.modules.CreateAccount


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ICreateAccountInteractor {

    interface Callback {
        fun onCreateAccountServerError()
        fun onUserAlreadyInUse()
        fun onCreateAccountSuccess()

    }

    fun  createAccount(email: String, anyString1: String,
                       listener: ICreateAccountInteractor.Callback?)
}