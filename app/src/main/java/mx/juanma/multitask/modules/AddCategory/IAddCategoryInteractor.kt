package mx.juanma.multitask.modules.AddCategory

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IAddCategoryInteractor {

    fun  addNewCategory(category: Category, callback: IAddCategoryInteractor.Callback?)

    interface Callback {
        fun onSessionExpired()
        fun onCategoryAdded()
        fun onInternalServerError()

    }
}