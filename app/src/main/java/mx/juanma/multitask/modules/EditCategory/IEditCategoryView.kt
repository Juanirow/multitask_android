package mx.juanma.multitask.modules.EditCategory


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
interface IEditCategoryView {
    fun getName(): String
    fun showNameEmptyError()
    fun getDefaultTime(): Int
    fun showProgressView()
    fun dismissProgressDialog()
    fun showDialogExpiredSession()
    fun closeActivityWithExpiredSessionCode()
    fun closeActivityWithOkResult()
    fun showInternalServerError()
}