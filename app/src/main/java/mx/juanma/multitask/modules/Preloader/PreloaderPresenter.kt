package mx.juanma.multitask.modules.Preloader


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