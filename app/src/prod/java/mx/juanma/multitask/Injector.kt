package mx.juanma.multitask

import mx.juanma.multitask.Injection.IProviders
import mx.juanma.multitask.modules.Login.ILoginInteractor
import mx.juanma.multitask.modules.Login.LoginInteractor


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object Injector: IProviders {

    override fun provideLoginInteractor(): ILoginInteractor {
        return LoginInteractor()
    }

}