package mx.juanma.multitask.modules.CreateAccount

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