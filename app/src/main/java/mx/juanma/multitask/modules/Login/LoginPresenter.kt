package mx.juanma.multitask.modules.Login


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginPresenter(val mView: ILoginView, val mInteractor: ILoginInteractor) {

    fun onLoginBtnClick() {
        val email = mView.getEmail()
        if(!validateEmail(email)) return
    }

    fun signUp(email: String, password: String, capture: ILoginInteractor.Callback) {}

    private fun validateEmail(email: String?): Boolean {
        if(email == null || email.isEmpty()) {
            this.mView.showEmailRequiredError()
            return false
        }
        return true
    }

}