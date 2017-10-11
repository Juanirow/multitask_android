package mx.juanma.multitask.modules.EditCategory


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryPresenter(val mView: IEditCategoryView, val mInteractor: IEditCategoryInteractor) {

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
    }

    fun onExpiredSessionConfirm() {
    }
}