package mx.juanma.multitask.modules.AddCategory

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryPresenter(var mView: IAddCategoryView,
                           var mInteractor: IAddCategoryInteractor) : IAddCategoryInteractor.Callback {

    /**
     * PRESENTER
     */

    fun onClickSave() {
        val name = this.mView.getName()
        if(name == null || name.isEmpty()) {
            this.mView.showNameEmptyError()
            return
        }
        val time = this.mView.getDefaultTime()
        this.mView.showProgressView()
        val category = Category(name, time)
        this.mInteractor.addNewCategory(category, this)

    }

    fun onExpiredSessionConfirm() {
        this.mView.closeActivityWithExpiredSessionCode()
    }

    /**
     * INTERACTOR CALLBACKS
     */

    override fun onSessionExpired() {
        this.mView.dismissProgressDialog()
        this.mView.showDialogExpiredSession()
    }

    override fun onCategoryAdded() {
        this.mView.dismissProgressDialog()
        this.mView.closeActivityWithOkResult()
    }

    override fun onInternalServerError() {
        this.mView.dismissProgressDialog()
        this.mView.showInternalServerError()
    }
}