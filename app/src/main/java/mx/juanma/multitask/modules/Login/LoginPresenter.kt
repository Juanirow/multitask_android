package mx.juanma.multitask.modules.Login


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginPresenter(val mView: ILoginView, val mInteractor: ILoginInteractor) {

    fun onLoginBtnClick() {
    }

    fun signUp(email: String, password: String, capture: ILoginInteractor.Callback) {}

}