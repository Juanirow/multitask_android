package mx.juanma.multitask.modules.Categories

import android.app.Fragment
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_categories.*
import mx.juanma.multitask.Constants
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.DialogCreator
import mx.juanma.multitask.models.Category
import mx.juanma.multitask.modules.AddCategory.AddCategoryActivity


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesFragment: Fragment(), ICategoriesView {

    private var mProgressDialog: ProgressDialog? = null

    companion object {
        @JvmStatic fun getInstance(): CategoriesFragment {
            val fragment = CategoriesFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.fragment_categories, container, false)
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.fabAddCategory.setOnClickListener {
            //TODO change to mvp
            val intent = Intent(this.activity, AddCategoryActivity::class.java)
            startActivityForResult(intent, Constants.REQUEST_ADD_CATEGORY)
        }
    }

    override fun showProgressDialog() {
        if(this.mProgressDialog == null) {
            this.mProgressDialog = DialogCreator.createProgressDialog(this.activity,
                    R.string.loading, R.string.loading_categories)
        }
        this.mProgressDialog?.show()
    }

    override fun closeProgressDialog() {
        this.mProgressDialog?.hide()
    }

    override fun closeActivityWithExpiredSessionResult() {
        this.activity.setResult(Constants.RESULT_EXPIRED_SESSION)
        this.activity.finish()
    }

    override fun showEmptyListDialog() {
        this.labelNoCategoriesSaved.visibility = View.VISIBLE
    }

    override fun hideListView() {
        this.listView.visibility = View.GONE
    }

    override fun hideEmptyListDialog() {
        this.labelNoCategoriesSaved.visibility = View.GONE
    }

    override fun showListView() {
        this.listView.visibility = View.VISIBLE
    }

    override fun loadCategoriesList(categories: ArrayList<Category>) {
        //TODO
    }

    override fun launchActivityWithCode(activityCode: Int) {
        val intent = Intent(this.activity, AddCategoryActivity::class.java)
        startActivityForResult(intent, activityCode)
    }
}