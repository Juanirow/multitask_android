package mx.juanma.multitask.modules.Main


/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class MainPresenter(var mView: IMainView,var mInteractor: IMainInteractor) {

    fun onClickLogout() {
        mInteractor.logout()
        mView.finishActivityWithOkResult()
    }
}