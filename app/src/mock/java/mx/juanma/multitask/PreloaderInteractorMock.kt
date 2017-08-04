package mx.juanma.multitask

import mx.juanma.multitask.modules.Preloader.IPreloaderInteractor


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class PreloaderInteractorMock: IPreloaderInteractor {

    override fun verifySession(listener: IPreloaderInteractor.Callback?) {
        listener?.onActiveSession()
    }
}