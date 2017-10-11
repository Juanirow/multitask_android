package mx.juanma.multitask.modules.EditCategory

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IEditCategoryInteractor {

    fun updateCategory(id: String, category: Category, callback: IEditCategoryInteractor.Callback?)

    interface Callback {
        fun onSessionExpired()
        fun onCategoryUpdate()
        fun onInternalServerError()
    }
}