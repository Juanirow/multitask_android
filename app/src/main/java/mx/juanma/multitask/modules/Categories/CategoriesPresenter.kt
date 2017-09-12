package mx.juanma.multitask.modules.Categories

import android.app.Activity
import mx.juanma.multitask.Constants
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
        this.mView.showProgressDialog()
        this.mInteractor.getUserCategories(this)
    }

    fun onClickAdd() {
        this.mView.launchActivityWithCode(Constants.REQUEST_ADD_CATEGORY)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int) {
        if(requestCode == Constants.REQUEST_ADD_CATEGORY) {
            if(resultCode == Activity.RESULT_OK) {
                this.loadCategories()
            }
        }
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
        else {
            this.mView.showListView()
            this.mView.hideEmptyListDialog()
            this.mView.loadCategoriesList(categories)
        }
    }
}