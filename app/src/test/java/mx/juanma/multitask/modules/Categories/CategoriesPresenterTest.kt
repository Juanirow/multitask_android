package mx.juanma.multitask.modules.Categories

import android.app.Activity
import mx.juanma.multitask.Constants
import mx.juanma.multitask.models.Category
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Matchers.*
import org.mockito.Mock
import org.mockito.Mockito

import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CategoriesPresenterTest {

    @Mock
    lateinit var mView: ICategoriesView

    @Mock
    lateinit var mInteractor: ICategoriesInteractor

    lateinit var mPresenter: CategoriesPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mPresenter = CategoriesPresenter(mView, mInteractor)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(mView, mInteractor)
    }

    @Test
    fun shouldCloseActivityWithExpiredSessionError() {
        val captor = ArgumentCaptor.forClass(ICategoriesInteractor.Callback::class.java)
        this.mPresenter.loadCategories()
        Mockito.verify(mView).showProgressDialog()
        Mockito.verify(mInteractor).getUserCategories(captor.capture())

        captor.value.onExpiredSession()
        Mockito.verify(mView).closeProgressDialog()
        Mockito.verify(mView).closeActivityWithExpiredSessionResult()
    }

    @Test
    fun shouldShowEmptyListMessage() {
        val captor = ArgumentCaptor.forClass(ICategoriesInteractor.Callback::class.java)
        this.mPresenter.loadCategories()
        Mockito.verify(mView).showProgressDialog()
        Mockito.verify(mInteractor).getUserCategories(captor.capture())

        val categories = ArrayList<Category>()
        captor.value.onLoadCategories(categories)
        Mockito.verify(mView).closeProgressDialog()
        Mockito.verify(mView).showEmptyListDialog()
        Mockito.verify(mView).hideListView()
    }

    @Test
    fun shouldShowCategoriesList() {
        val captor = ArgumentCaptor.forClass(ICategoriesInteractor.Callback::class.java)
        this.mPresenter.loadCategories()
        Mockito.verify(mView).showProgressDialog()
        Mockito.verify(mInteractor).getUserCategories(captor.capture())

        val categories = ArrayList<Category>()
        categories.add(Category("Deporte"))
        categories.add(Category("Casa"))
        captor.value.onLoadCategories(categories)
        Mockito.verify(mView).closeProgressDialog()
        Mockito.verify(mView).hideEmptyListDialog()
        Mockito.verify(mView).showListView()
        Mockito.verify(mView).loadCategoriesList(categories)
    }

    @Test
    fun shouldLaunchAddCategoryActivity() {
        this.mPresenter.onClickAdd()
        Mockito.verify(mView).launchActivityWithCode(Mockito.anyInt())
    }

    @Test
    fun shouldShowDialogToConfirmDeleteCategory() {
        mPresenter.onDeleteCategoryClick(anyString(), anyString())
        Mockito.verify(mView).showDeleteConfirmationDialog(anyString(), anyString())
    }

    @Test
    fun reloadListAfterDeleteItem() {
        val captor = ArgumentCaptor.forClass(ICategoriesInteractor.DeleteCallback::class.java)

        mPresenter.confirmDeleteCategory("asd")
        Mockito.verify(mView).showProgressDialogDeleteItem()
        Mockito.verify(mInteractor).onDeleteCategory(Mockito.anyString(), captor.capture())

        captor.value.onDeleteSuccess()
        Mockito.verify(this.mView).closeProgressDialog()
        Mockito.verify(this.mView).onDeleteCategorySuccess()
    }

    @Test
    fun closeSessionAfterDeleteItemError() {
        val captor = ArgumentCaptor.forClass(ICategoriesInteractor.DeleteCallback::class.java)

        mPresenter.confirmDeleteCategory("asd")
        Mockito.verify(mView).showProgressDialogDeleteItem()
        Mockito.verify(mInteractor).onDeleteCategory(anyString(), captor.capture())

        captor.value.onExpiredSessionDuringDelete()
        Mockito.verify(this.mView).closeProgressDialog()
        Mockito.verify(mView).closeActivityWithExpiredSessionResult()
    }

    @Test
    fun shouldLaunchEditCategoryActivity() {
        mPresenter.onEditCategory("nailhaId")
        Mockito.verify(mView).launchEditCategory(anyString(), anyInt())
    }

    @Test
    fun shouldReloadListAfterEditSuccess() {
        mPresenter.onActivityResult(Constants.REQUEST_EDIT_CATEGORY, Activity.RESULT_OK)
        Mockito.verify(mView).onUpdateCategorySuccess()
    }

    @Test
    fun shouldNotAction() {
        mPresenter.onActivityResult(Constants.REQUEST_EDIT_CATEGORY, Activity.RESULT_CANCELED)
        Mockito.verify(mView).onUpdateCategorySuccess()
    }

    @Test
    fun shouldCloseActivityAfterExpiredSessionResponse() {
        mPresenter.onActivityResult(Constants.REQUEST_EDIT_CATEGORY,
                Constants.RESULT_EXPIRED_SESSION)
        Mockito.verify(mView).closeActivityWithExpiredSessionResult()
    }
}