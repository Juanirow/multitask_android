package mx.juanma.multitask.modules.Login

import android.app.Activity
import android.app.Fragment
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.DialogCreator
import mx.juanma.multitask.helpers.ViewHelper
import mx.juanma.multitask.modules.CreateAccount.CreateAccountActivity


/**
 * Created by Juancho on 28/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginFragment: Fragment(), ILoginView {

    var mPresenter: LoginPresenter? = null
    var mProgressDialog: ProgressDialog? = null

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
        ViewHelper.setTextInputLayoutError(R.string.error_email_invalid, labelEmail, this.activity)
    }

    override fun showPasswordRequiredError() {
        ViewHelper.setTextInputLayoutError(R.string.error_password_required,
                labelPassword, this.activity)
    }

    override fun showPasswordWrongLengthError() {
        ViewHelper.setTextInputLayoutError(R.string.error_password_wrong_length,
                labelPassword, this.activity)
    }

    override fun showProgressDialog() {
        if(this.mProgressDialog == null) {
            this.mProgressDialog = DialogCreator.createProgressDialog(this.activity,
                    R.string.validating_credentials, R.string.validating_credentials)
        }
        this.mProgressDialog?.show()
    }

    override fun hideProgressDialog() {
        this.mProgressDialog?.dismiss()
    }

    override fun showServerError() {
        DialogCreator.showError(this.activity, R.string.error_server_generic)
    }

    override fun showWrongCredentialsError() {
        DialogCreator.showError(this.activity, R.string.error_wrong_credentials)
    }

    override fun closeActivityWithOkResult() {
        this.activity.setResult(Activity.RESULT_OK)
        this.activity.finish()
    }

    override fun launchCreateAccountActivity() {
        val intent = Intent(this.activity, CreateAccountActivity::class.java)
        startActivityForResult(intent, 0)
    }
}