package mx.juanma.multitask.modules.EditCategory

import mx.juanma.multitask.models.Category


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryPresenter(val mView: IEditCategoryView, val mInteractor: IEditCategoryInteractor) : IEditCategoryInteractor.Callback {

    /**
     * PRESENTER
     * user actions
     */

    fun onClickSave() {
        val name = this.mView.getName()
        if(name.isEmpty()) {
            this.mView.showNameEmptyError()
            return
        }

        val time = this.mView.getDefaultTime()
        val id = this.mView.getCategoryId()
        this.mView.showProgressView()
        val category = Category(name, time, id)
        this.mInteractor.updateCategory(id, category, this)
    }

    fun onExpiredSessionConfirm() {
        this.mView.closeActivityWithExpiredSessionCode()
    }

    /**
     * CALLBACK INTERACTOR
     * server responses
     */

    override fun onSessionExpired() {
        this.mView.dismissProgressDialog()
        this.mView.showDialogExpiredSession()
    }

    override fun onCategoryUpdate() {
        this.mView.dismissProgressDialog()
        this.mView.closeActivityWithOkResult()
    }

    override fun onInternalServerError() {
        this.mView.dismissProgressDialog()
        this.mView.showInternalServerError()
    }
}