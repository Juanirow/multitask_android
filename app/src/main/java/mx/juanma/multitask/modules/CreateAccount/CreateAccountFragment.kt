package mx.juanma.multitask.modules.CreateAccount

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_create_account.*
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.ViewHelper


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountFragment: Fragment(), ICreateAccountView {

    var mPresenter: CreateAccountPresenter? = null

    companion object {
        @JvmStatic fun getInstance(): CreateAccountFragment {
            val fragment = CreateAccountFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_create_account, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.mPresenter = CreateAccountPresenter(this, Injector.provideCreateAccountInteractor())
        this.btnCreateAccount.setOnClickListener { mPresenter?.onClickCreateAccount() }
    }

    /**
     * View
     */

    override fun getEmail(): String {
        this.labelEmail.error = null
        this.labelEmail.isErrorEnabled = false
        return this.inputEmail.text.toString().trim()
    }

    override fun getPassword(): String {
        this.labelPassword.error = null
        this.labelPassword.isErrorEnabled = false
        return this.inputPassword.text.toString().trim()
    }

    override fun getPasswordAgain(): String {
        this.labelPasswordAgain.error = null
        this.labelPasswordAgain.isErrorEnabled = false
        return this.inputPasswordAgain.text.toString().trim()
    }

    override fun showEmailRequiredError() {
        ViewHelper.setTextInputLayoutError(R.string.error_email_required, this.labelEmail,
                this.activity)
    }

    override fun showEmailInvalidError() {
        ViewHelper.setTextInputLayoutError(R.string.error_email_invalid, this.labelEmail,
                this.activity)
    }

    override fun showPasswordRequiredError() {
    }

    override fun showPasswordWrongLengthError() {
    }

    override fun showPasswordNotMatchError() {
    }

    override fun showProgressDialog() {
    }

    override fun hideProgressDialog() {
    }

    override fun showServerError() {
    }

    override fun showUserAlreadyInUserError() {
    }

    override fun closeActivityWithOkResult() {
    }
}