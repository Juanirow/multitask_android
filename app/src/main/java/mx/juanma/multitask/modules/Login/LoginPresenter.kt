package mx.juanma.multitask.modules.Login

import mx.juanma.multitask.helpers.EmailValidator


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginPresenter(val mView: ILoginView, val mInteractor: ILoginInteractor) {

    fun onLoginBtnClick() {
        val email = mView.getEmail()
        if(!validateEmail(email)) return
        val password = mView.getPassword()
        if(!validatePassword(password)) return

    }

    fun signUp(email: String, password: String, capture: ILoginInteractor.Callback) {}

    private fun validatePassword(password: String?): Boolean {
        if(password == null || password.isEmpty()) {
            this.mView.showPasswordRequiredError()
            return false
        }

        return true
    }

    private fun validateEmail(email: String?): Boolean {
        if(email == null || email.isEmpty()) {
            this.mView.showEmailRequiredError()
            return false
        }
        if(!EmailValidator.isValid(email)) {
            this.mView.showEmailInvalid()
            return false
        }
        return true
    }

}