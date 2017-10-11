package mx.juanma.multitask.modules.Categories

import android.app.Fragment
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_categories.*
import mx.juanma.multitask.Constants
import mx.juanma.multitask.Injector
import mx.juanma.multitask.R
import mx.juanma.multitask.helpers.DialogCreator
import mx.juanma.multitask.models.Category
import mx.juanma.multitask.modules.AddCategory.AddCategoryActivity
import mx.juanma.multitask.modules.Categories.CategoryItem.CategoriesAdapter
import mx.juanma.multitask.modules.Categories.CategoryItem.ICategoryItemActionListener
import mx.juanma.multitask.modules.EditCategory.EditCategoryActivity
import mx.juanma.multitask.modules.EditCategory.EditCategoryFragment


/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesFragment: Fragment(), ICategoriesView, ICategoryItemActionListener {

    private var mProgressDialog: ProgressDialog? = null
    private var mAdapter: CategoriesAdapter? = null
    lateinit var mPresenter: CategoriesPresenter

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


        this.mAdapter = CategoriesAdapter(this.activity, this)
        this.listView.adapter = this.mAdapter
        this.listView.layoutManager = LinearLayoutManager(this.activity)

        this.mPresenter = CategoriesPresenter(this, Injector.categoriesInteractor())
        this.mPresenter.loadCategories()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        this.mPresenter.onActivityResult(requestCode, resultCode)
    }

    /**
     * View Contract
     */

    override fun showProgressDialog() {
        this.mProgressDialog = DialogCreator.createProgressDialog(this.activity,
                R.string.loading, R.string.loading_categories)
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
        this.mAdapter?.updateCategories(categories)
    }

    override fun launchActivityWithCode(activityCode: Int) {
        val intent = Intent(this.activity, AddCategoryActivity::class.java)
        startActivityForResult(intent, activityCode)
    }

    override fun showDeleteConfirmationDialog(id: String, name: String) {
        val listener = DialogInterface.OnClickListener { dialog, which ->
            this.mPresenter.confirmDeleteCategory(id)
        }
        val error = this.getString(R.string.removing_message)
        val message = String.format(error, name)
        DialogCreator.showConfirmDialog(this.activity, R.string.removing, message, listener, null)
    }

    override fun showProgressDialogDeleteItem() {
        this.mProgressDialog = DialogCreator.createProgressDialog(this.activity,
                R.string.removing, R.string.removing_category)
        this.mProgressDialog?.show()
    }

    override fun onDeleteCategorySuccess() {
        this.mPresenter.loadCategories()
    }

    override fun launchEditCategory(categoryId: String, requestCode: Int) {
        val intent = Intent(this.activity, EditCategoryActivity::class.java)
        intent.putExtra(EditCategoryFragment.EXTRA_CATEGORY_ID, categoryId)
        startActivityForResult(intent, requestCode)
    }

    /**
     * CATEGORIES LIST ITEM LISTENER
     */

    override fun onClickEditItem(id: String, name: String, seconds: Int) {
        this.mPresenter.onEditCategory(id)
    }

    override fun onClickDeleteItem(id: String, name: String) {
        this.mPresenter.onDeleteCategoryClick(id, name)
    }
}