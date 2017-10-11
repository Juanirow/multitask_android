package mx.juanma.multitask.modules.EditCategory

import android.app.Activity
import android.app.Fragment
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_edit_category.*
import mx.juanma.multitask.Constants
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.DialogCreator
import mx.juanma.multitask.helpers.ViewHelper


/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryFragment: Fragment(), IEditCategoryView {

    private var mProgressDialog: ProgressDialog? = null
    private var defaultsTimeList: IntArray? = null
    private var mPresenter: EditCategoryPresenter? = null
    private lateinit var categoryId: String

    companion object {
        @JvmStatic val EXTRA_CATEGORY_ID = "_categoryId"
        @JvmStatic fun getInstance(): EditCategoryFragment {
            val fragment = EditCategoryFragment()
            fragment.retainInstance = true
            return fragment
         }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_edit_category, container, false)
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.defaultsTimeList = resources.getIntArray(R.array.time_templates_seconds)
        this.categoryId = this.activity.intent.getStringExtra(EXTRA_CATEGORY_ID)
        this.fabOk.setOnClickListener { this.mPresenter?.onClickSave() }
        this.mPresenter = EditCategoryPresenter(this, Injector.editCategoriesInteractor())
    }

    /**
     * VIEW
     * interface actions of the user
     */

    override fun getName(): String {
        this.labelName.error = null
        this.labelName.isErrorEnabled = false
        return this.inputName.text.toString().trim()
    }

    override fun showNameEmptyError() {
        ViewHelper.setTextInputLayoutError(R.string.error_category_required, this.labelName,
                this.activity)
    }

    override fun getDefaultTime(): Int {
        val currentIndex = this.spinnerTimeTemplate.selectedItemPosition
        // return default one hour or the template time
        return if(this.defaultsTimeList != null) this.defaultsTimeList!![currentIndex] else 60
    }

    override fun showProgressView() {
        if(this.mProgressDialog == null) {
            this.mProgressDialog = DialogCreator.createProgressDialog(this.activity,
                    R.string.loading, R.string.updating_category)
        }
        this.mProgressDialog?.show()
    }

    override fun dismissProgressDialog() {
        this.mProgressDialog?.dismiss()
    }

    override fun showDialogExpiredSession() {
        DialogCreator.showError(this.activity, R.string.error_expired_session, null,
                DialogInterface.OnDismissListener {
                    this.mPresenter?.onExpiredSessionConfirm()
                })
    }

    override fun closeActivityWithExpiredSessionCode() {
        this.activity.setResult(Constants.RESULT_EXPIRED_SESSION)
        this.activity.finish()
    }

    override fun closeActivityWithOkResult() {
        this.activity.setResult(Activity.RESULT_OK)
        this.activity.finish()
    }

    override fun showInternalServerError() {
        DialogCreator.showError(this.activity, R.string.error_server_generic, null, null)
    }

    override fun getCategoryId(): String = categoryId
}