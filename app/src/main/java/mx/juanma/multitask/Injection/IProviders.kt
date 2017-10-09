package mx.juanma.multitask.Injection

import mx.juanma.multitask.modules.AddCategory.IAddCategoryInteractor
import mx.juanma.multitask.modules.Categories.ICategoriesInteractor
import mx.juanma.multitask.modules.CreateAccount.ICreateAccountInteractor
import mx.juanma.multitask.modules.Login.ILoginInteractor
import mx.juanma.multitask.modules.Main.IMainInteractor
import mx.juanma.multitask.modules.Preloader.IPreloaderInteractor


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IProviders {

    fun provideLoginInteractor(): ILoginInteractor

    fun provideCreateAccountInteractor(): ICreateAccountInteractor

    fun providePreloaderInteractor(): IPreloaderInteractor

    fun provideMainInteractor(): IMainInteractor

    fun provideAddCategoryInteractor(): IAddCategoryInteractor

    fun categoriesInteractor(): ICategoriesInteractor
}