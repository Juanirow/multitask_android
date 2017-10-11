package mx.juanma.multitask

import mx.juanma.multitask.Injection.IProviders
import mx.juanma.multitask.modules.AddCategory.AddCategoryInteractor
import mx.juanma.multitask.modules.AddCategory.IAddCategoryInteractor
import mx.juanma.multitask.modules.Categories.CategoriesInteractor
import mx.juanma.multitask.modules.Categories.ICategoriesInteractor
import mx.juanma.multitask.modules.CreateAccount.CreateAccountInteractor
import mx.juanma.multitask.modules.CreateAccount.ICreateAccountInteractor
import mx.juanma.multitask.modules.EditCategory.EditCategoryInteractor
import mx.juanma.multitask.modules.EditCategory.IEditCategoryInteractor
import mx.juanma.multitask.modules.Login.ILoginInteractor
import mx.juanma.multitask.modules.Login.LoginInteractor
import mx.juanma.multitask.modules.Main.IMainInteractor
import mx.juanma.multitask.modules.Main.MainInteractor
import mx.juanma.multitask.modules.Preloader.IPreloaderInteractor
import mx.juanma.multitask.modules.Preloader.PreloaderFragment
import mx.juanma.multitask.modules.Preloader.PreloaderInteractor


/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object Injector: IProviders {

    override fun provideLoginInteractor(): ILoginInteractor {
        return LoginInteractor()
    }

    override fun provideCreateAccountInteractor(): ICreateAccountInteractor {
        return CreateAccountInteractor()
    }

    override fun providePreloaderInteractor(): IPreloaderInteractor {
        return PreloaderInteractor()
    }

    override fun provideMainInteractor(): IMainInteractor {
        return MainInteractor()
    }

    override fun provideAddCategoryInteractor(): IAddCategoryInteractor {
        return AddCategoryInteractor()
    }

    override fun categoriesInteractor(): ICategoriesInteractor {
        return CategoriesInteractor()
    }

    override fun editCategoriesInteractor(): IEditCategoryInteractor {
        return EditCategoryInteractor()
    }
}