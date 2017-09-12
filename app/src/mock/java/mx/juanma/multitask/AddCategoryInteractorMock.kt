package mx.juanma.multitask

import mx.juanma.multitask.models.Category
import mx.juanma.multitask.modules.AddCategory.IAddCategoryInteractor


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryInteractorMock: IAddCategoryInteractor {

    override fun addNewCategory(category: Category, callback: IAddCategoryInteractor.Callback?) {
        var name = ""
        if(category.name == null) {
           name = category.name!!
        }
        when(name) {
            "test_expiredSession" -> { callback?.onSessionExpired() }
            "test_server" -> { callback?.onInternalServerError() }
            else -> { callback?.onCategoryAdded() }
        }
    }
}