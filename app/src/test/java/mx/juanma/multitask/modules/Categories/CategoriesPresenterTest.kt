package mx.juanma.multitask.modules.Categories

import mx.juanma.multitask.models.Category
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
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

}