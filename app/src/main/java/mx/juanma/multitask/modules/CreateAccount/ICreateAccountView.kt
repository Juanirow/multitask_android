package mx.juanma.multitask.modules.CreateAccount


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ICreateAccountView {

    fun getEmail(): String
    fun getPassword(): String
    fun getPasswordAgain(): String
    fun showEmailRequiredError()
    fun showEmailInvalidError()
    fun showPasswordRequiredError()
    fun showPasswordWrongLengthError()
    fun showPasswordNotMatchError()
    fun showProgressDialog()
    fun hideProgressDialog()
    fun showServerError()
    fun showUserAlreadyInUserError()
    fun closeActivityWithOkResult()
}