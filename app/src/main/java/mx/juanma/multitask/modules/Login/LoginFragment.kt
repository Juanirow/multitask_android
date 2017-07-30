package mx.juanma.multitask.modules.Login

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.ViewHelper


/**
 * Created by Juancho on 28/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginFragment: Fragment(), ILoginView {

    var mPresenter: LoginPresenter? = null

    companion object {
        @JvmStatic fun getInstance(): LoginFragment {
            val fragment = LoginFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.fragment_login, container, false)
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.mPresenter = LoginPresenter(this, Injector.provideLoginInteractor())
        this.btnLogin.setOnClickListener { this.mPresenter?.onLoginBtnClick() }
        this.btnCreateAccount.setOnClickListener { this.mPresenter?.onCreateAccountButton() }
    }

    override fun getEmail(): String? {
        this.labelEmail.error = null
        this.labelEmail.isErrorEnabled = false
        return this.inputEmail.text.toString().trim()
    }

    override fun getPassword(): String? {
        this.labelPassword.error = null
        this.labelPassword.isErrorEnabled = false
        return this.inputPassword.text.toString().trim()
    }

    override fun showEmailRequiredError() {
        ViewHelper.setTextInputLayoutError(R.string.error_email_required, labelEmail, this.activity)
    }

    override fun showEmailInvalid() {
    }

    override fun showPasswordRequiredError() {
    }

    override fun showPasswordWrongLengthError() {
    }

    override fun showProgressDialog() {
    }

    override fun hideProgressDialog() {
    }

    override fun showServerError() {
    }

    override fun showWrongCredentialsError() {
    }

    override fun closeActivityWithOkResult() {
    }

    override fun launchCreateAccountActivity() {
    }
}