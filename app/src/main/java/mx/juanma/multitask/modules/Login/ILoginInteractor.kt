package mx.juanma.multitask.modules.Login


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ILoginInteractor {

    interface Callback {
        fun onLoginSuccessful()
        fun onLoginServerError()
        fun onWrongCredentials()

    }

    fun  signUp(email: String, password: String, listener: ILoginInteractor.Callback)
}