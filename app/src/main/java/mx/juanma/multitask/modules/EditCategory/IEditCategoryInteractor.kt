package mx.juanma.multitask.modules.EditCategory

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IEditCategoryInteractor {

    fun addNewCategory(category: Category, capture: IEditCategoryInteractor.Callback?)

    interface Callback {
        fun onSessionExpired()
        fun onCategoryUpdate()
        fun onInternalServerError()
    }
}