package mx.juanma.multitask.modules.Preloader

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.juanma.multitask.Constants
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.modules.Login.LoginActivity
import mx.juanma.multitask.modules.Main.MainActivity


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class PreloaderFragment: Fragment(), IPreloaderView {

    val TAG = "PreloaderFragment"
    var mPresenter: PreloaderPresenter? = null

    companion object {
        fun getInstance(): PreloaderFragment {
            val fragment = PreloaderFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_preloader, container, false)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter = PreloaderPresenter(this, Injector.providePreloaderInteractor())
        mPresenter?.verifyCurrentSession()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mPresenter?.activityResult(requestCode, resultCode)
    }

    /**
     * VIEW
     */

    override fun launchMainActivity() {
        Log.d(TAG, "launchMainActivity: ")
        val intent = Intent(this.activity, MainActivity::class.java)
        startActivityForResult(intent, Constants.REQUEST_MAIN_ACTIVITY)
    }

    override fun launchLoginActivity() {
        val intent = Intent(this.activity, LoginActivity::class.java)
        startActivityForResult(intent, Constants.REQUEST_LOGIN_ACTIVITY)
    }

    override fun closeActivity() {
        this.activity.finish()
    }
}