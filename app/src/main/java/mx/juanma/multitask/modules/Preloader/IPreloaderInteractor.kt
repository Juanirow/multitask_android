package mx.juanma.multitask.modules.Preloader


/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IPreloaderInteractor {

    interface Callback {
        fun onActiveSession()
        fun onInActiveSession()

    }

    fun  verifySession(listener: IPreloaderInteractor.Callback?)
}