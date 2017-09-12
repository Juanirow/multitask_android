package mx.juanma.multitask.modules.AddCategory

import android.app.Fragment
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_category.*
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.DialogCreator
import mx.juanma.multitask.helpers.ViewHelper


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryFragment : Fragment(), IAddCategoryView {

    private var mPresenter: AddCategoryPresenter? = null
    private var mProgressDialog: ProgressDialog? = null

    companion object {
        @JvmStatic fun getInstance(): AddCategoryFragment {
            val fragment = AddCategoryFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.fragment_add_category, container, false)
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.mPresenter = AddCategoryPresenter(this, Injector.provideAddCategoryInteractor())
        this.fabOk.setOnClickListener { this.mPresenter?.onClickSave() }
    }

    /**
     * VIEW
     */

    override fun getName(): String? {
        this.labelName.error = null
        this.labelName.isErrorEnabled = false
        return this.inputName.text.toString().trim()
    }

    override fun showNameEmptyError() {
        ViewHelper.setTextInputLayoutError(R.string.error_category_required,
                this.labelName, this.activity)
    }

    override fun showProgressView() {
        if(this.mProgressDialog == null) {
            this.mProgressDialog = DialogCreator.createProgressDialog(this.activity,
                    R.string.loading, R.string.adding_category)
        }
        this.mProgressDialog?.show()
    }

    override fun dismissProgressDialog() {
        this.mProgressDialog?.dismiss()
    }

    override fun showDialogExpiredSession() {
    }

    override fun closeActivityWithExpiredSessionCode() {
    }

    override fun closeActivityWithOkResult() {
    }

    override fun showInternalServerError() {
        DialogCreator.showError(this.activity, R.string.error_server_generic)
    }
}