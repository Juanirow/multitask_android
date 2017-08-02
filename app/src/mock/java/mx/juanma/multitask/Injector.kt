package mx.juanma.multitask

import mx.juanma.multitask.Injection.IProviders
import mx.juanma.multitask.modules.CreateAccount.ICreateAccountInteractor
import mx.juanma.multitask.modules.Login.ILoginInteractor


/**
 * Created by Juancho on 30/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object Injector: IProviders {

    override fun provideLoginInteractor(): ILoginInteractor {
        return LoginInteractorMock()
    }

    override fun provideCreateAccountInteractor(): ICreateAccountInteractor {
        return CreateAccountInteractorMock()
    }
}