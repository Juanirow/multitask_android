package mx.juanma.multitask.modules.Categories

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface ICategoriesView {
    fun showProgressDialog()
    fun getUserCategories(listener: ICategoriesInteractor.Callback?)
    fun closeProgressDialog()
    fun closeActivityWithExpiredSessionResult()
    fun showEmptyListDialog()
    fun hideListView()
    fun hideEmptyListDialog()
    fun showListView()
    fun  loadCategoriesList(categories: ArrayList<Category>)
}