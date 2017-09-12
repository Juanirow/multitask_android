package mx.juanma.multitask.modules.Categories

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ICategoriesInteractor {

    fun getUserCategories(callback: ICategoriesInteractor.Callback?)

    interface Callback {
        fun onExpiredSession()
        fun onLoadCategories(categories: ArrayList<Category>)

    }
}