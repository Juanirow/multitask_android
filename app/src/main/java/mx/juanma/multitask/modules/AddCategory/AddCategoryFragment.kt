package mx.juanma.multitask.modules.AddCategory

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_category.*
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryFragment : Fragment(), IAddCategoryView {

    private var mPresenter: AddCategoryPresenter? = null

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
    }

    override fun showProgressView() {
    }

    override fun dismissProgressDialog() {
    }

    override fun showDialogExpiredSession() {
    }

    override fun closeActivityWithExpiredSessionCode() {
    }

    override fun closeActivityWithOkResult() {
    }

    override fun showInternalServerError() {
    }
}