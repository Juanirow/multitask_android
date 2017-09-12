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
        this.mView.showProgressView()
        val category = Category(name)
        this.mInteractor.addNewCategory(category, this)

    }

    fun onExpiredSessionConfirm() {
    }

    /**
     * INTERACTOR CALLBACKS
     */

    override fun onSessionExpired() {
        this.mView.dismissProgressDialog()
        this.mView.showDialogExpiredSession()
    }

    override fun onCategoryAdded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInternalServerError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}