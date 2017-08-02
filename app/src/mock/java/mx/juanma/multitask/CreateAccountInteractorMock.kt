package mx.juanma.multitask

import mx.juanma.multitask.modules.CreateAccount.ICreateAccountInteractor


/**
 * Created by Juancho on 02/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountInteractorMock: ICreateAccountInteractor {

    override fun createAccount(email: String, anyString1: String,
                               listener: ICreateAccountInteractor.Callback?) {
    }

}