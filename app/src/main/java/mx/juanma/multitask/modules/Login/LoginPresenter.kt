package mx.juanma.multitask.modules.Login

import mx.juanma.multitask.helpers.EmailValidator


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginPresenter(val mView: ILoginView, val mInteractor: ILoginInteractor):
        ILoginInteractor.Callback {

    private val PASSWORD_MIN_LEN = 6

    fun onCreateAccountButton() {
        this.mView.launchCreateAccountActivity()
    }

    fun onLoginBtnClick() {
        val email = mView.getEmail()
        if(!validateEmail(email)) return
        val password = mView.getPassword()
        if(!validatePassword(password)) return
        mView.showProgressDialog()
        mInteractor.signUp(email!!, password!!, this)
    }

    private fun validatePassword(password: String?): Boolean {
        if(password == null || password.isEmpty()) {
            this.mView.showPasswordRequiredError()
            return false
        }
        if(password.length < PASSWORD_MIN_LEN) {
            this.mView.showPasswordWrongLengthError()
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

    /**
     * Interactor CALLBACK
     */

    override fun onLoginSuccessful() {
        this.mView.hideProgressDialog()
        this.mView.closeActivityWithOkResult()
    }

    override fun onLoginServerError() {
        this.mView.hideProgressDialog()
        this.mView.showServerError()
    }

    override fun onWrongCredentials() {
        this.mView.hideProgressDialog()
        this.mView.showWrongCredentialsError()
    }

}