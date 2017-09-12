package mx.juanma.multitask.modules.AddCategory


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IAddCategoryView {

    fun getName(): String?
    fun showNameEmptyError()
    fun showProgressView()
    fun dismissProgressDialog()
    fun showDialogExpiredSession()
    fun closeActivityWithExpiredSessionCode()
    fun closeActivityWithOkResult()
    fun showInternalServerError()
}