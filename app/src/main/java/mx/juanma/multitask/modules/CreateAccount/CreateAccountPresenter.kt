package mx.juanma.multitask.modules.CreateAccount

import mx.juanma.multitask.Constants
import mx.juanma.multitask.helpers.EmailValidator
import mx.juanma.multitask.helpers.ViewHelper


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountPresenter(var mView: ICreateAccountView,
                             var mInteractor: ICreateAccountInteractor) {

    fun onClickCreateAccount() {
        val email = mView.getEmail()
        if(!validateEmail(email)) return
        val password = mView.getPassword()
        if(!validPassword(password)) return
        val passwordAgain = mView.getPasswordAgain()
        if(password != passwordAgain) {
            mView.showPasswordNotMatchError()
            return
        }
    }
    private fun validPassword(password: String): Boolean {
        if(password.isEmpty()) {
            mView.showPasswordRequiredError()
            return false
        }
        if(password.length < Constants.MINIMUM_PASSWORD_LENGTH) {
            mView.showPasswordWrongLengthError()
            return false
        }
        return true
    }

    private fun validateEmail(email: String): Boolean {
        if(email.isEmpty()) {
            mView.showEmailRequiredError()
            return false
        }

        if(!EmailValidator.isValid(email)){
            mView.showEmailInvalidError()
            return false
        }
        return true
    }
}