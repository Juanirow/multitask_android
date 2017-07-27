package mx.juanma.multitask.modules.Login


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ILoginView {
    fun getEmail(): String?
    fun getPassword(): String?
    fun showEmailRequiredError()
    fun showEmailInvalid()
    fun showPasswordRequiredError()
    fun showPasswordWrongLengthError()
    fun showProgressDialog()
    fun hideProgressDialog()
    fun showServerError()
    fun showWrongCredentialsError()
    fun closeActivityWithOkResult()
}