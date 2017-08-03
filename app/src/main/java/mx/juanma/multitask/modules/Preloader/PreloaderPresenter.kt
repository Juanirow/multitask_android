package mx.juanma.multitask.modules.Preloader

import android.app.Activity
import mx.juanma.multitask.Constants


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class PreloaderPresenter(var mView: IPreloaderView, var mInteractor: IPreloaderInteractor) : IPreloaderInteractor.Callback {

    fun verifyCurrentSession() {
        mInteractor.verifySession(this)
    }

    fun  activityResult(requestCode: Int, resultCode: Int) {
        when(requestCode) {
            Constants.REQUEST_MAIN_ACTIVITY -> {
                if(resultCode == Activity.RESULT_OK) {
                    mView.launchLoginActivity()
                }
                else {
                    mView.closeActivity()
                }
            }
            Constants.REQUEST_LOGIN_ACTIVITY -> {
                if(resultCode == Activity.RESULT_OK) {
                    mInteractor.verifySession(this)
                }
            }
        }

    }

    /**
     * CALLBACK INTERACTOR
     */

    override fun onActiveSession() {
        mView.launchMainActivity()
    }

    override fun onInActiveSession() {
        mView.launchLoginActivity()
    }
}