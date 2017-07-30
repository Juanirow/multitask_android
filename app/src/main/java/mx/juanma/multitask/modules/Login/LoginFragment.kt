package mx.juanma.multitask.modules.Login

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R


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
    }

    override fun getEmail(): String? {
        return null
    }

    override fun getPassword(): String? {
        return null
    }

    override fun showEmailRequiredError() {
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