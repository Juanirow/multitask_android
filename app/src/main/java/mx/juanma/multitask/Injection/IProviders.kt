package mx.juanma.multitask.Injection

import mx.juanma.multitask.modules.Login.ILoginInteractor


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IProviders {

    fun provideLoginInteractor(): ILoginInteractor
}