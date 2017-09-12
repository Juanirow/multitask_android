package mx.juanma.multitask.modules.Categories

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesPresenter(var mView: ICategoriesView, var mInteractor: ICategoriesInteractor):
        ICategoriesInteractor.Callback {

    /**
     *  Presenter Calls
     */
    fun loadCategories() {
        mView.showProgressDialog()
        mInteractor.getUserCategories(this)
    }

    /**
     * ICategoriesInteractorCallback
     */

    override fun onExpiredSession() {
        this.mView.closeProgressDialog()
        this.mView.closeActivityWithExpiredSessionResult()
    }

    override fun onLoadCategories(categories: ArrayList<Category>) {
        this.mView.closeProgressDialog()
        if(categories.isEmpty()) {
            this.mView.hideListView()
            this.mView.showEmptyListDialog()
        }
    }
}