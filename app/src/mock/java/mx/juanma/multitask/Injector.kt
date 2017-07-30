package mx.juanma.multitask

import mx.juanma.multitask.modules.Login.ILoginInteractor


/**
 * Created by Juancho on 30/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object Injector {

    fun provideLoginInteractor(): ILoginInteractor {
        return LoginInteractorMock()
    }
}