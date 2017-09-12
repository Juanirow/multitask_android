package mx.juanma.multitask.modules.AddCategory


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryPresenter(var mView: IAddCategoryView,
                           var mInteractor: IAddCategoryInteractor) {

    fun onClickSave() {
        val email = this.mView.getName()
        if(email == null || email.isEmpty()) {
            this.mView.showNameEmptyError()
        }
    }

    fun onExpiredSessionConfirm() {
    }
}