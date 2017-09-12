package mx.juanma.multitask.modules.AddCategory

import mx.juanma.multitask.models.Category
import org.junit.After

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
class AddCategoryPresenterTest {

    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T

    @Mock
    lateinit var mView: IAddCategoryView

    @Mock
    lateinit var mInteractor: IAddCategoryInteractor

    lateinit var mPresenter: AddCategoryPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mPresenter = AddCategoryPresenter(mView, mInteractor)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(mView, mInteractor)
    }

    @Test
    fun shouldShowAnErrorEmptyName() {
        Mockito.`when`(this.mView.getName()).thenReturn("")

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(mView).showNameEmptyError()
    }

    @Test
    fun shouldShowExpiredSession() {
        val captor = ArgumentCaptor.forClass(IAddCategoryInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getName()).thenReturn("Deporte")

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(mView).showProgressView()
        Mockito.verify(mInteractor).addNewCategory(any(), captor.capture())

        captor.value.onSessionExpired()
        Mockito.verify(mView).dismissProgressDialog()
        Mockito.verify(mView).showDialogExpiredSession()
    }

    @Test
    fun shouldCloseActivityWithResultExpiredSession() {
        this.mPresenter.onExpiredSessionConfirm()
        Mockito.verify(mView).closeActivityWithExpiredSessionCode()
    }

    @Test
    fun shouldReturnOkResultAfterAddNewCategory() {
        val captor = ArgumentCaptor.forClass(IAddCategoryInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getName()).thenReturn("Deporte")

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(mView).showProgressView()
        Mockito.verify(mInteractor).addNewCategory(any(), captor.capture())

        captor.value.onCategoryAdded()
        Mockito.verify(mView).dismissProgressDialog()
        Mockito.verify(mView).closeActivityWithOkResult()
    }

    @Test
    fun shouldShowInternalServerError() {
        val captor = ArgumentCaptor.forClass(IAddCategoryInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getName()).thenReturn("Deporte")

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(mView).showProgressView()
        Mockito.verify(mInteractor).addNewCategory(any(), captor.capture())

        captor.value.onInternalServerError()
        Mockito.verify(mView).dismissProgressDialog()
        Mockito.verify(mView).showInternalServerError()
    }
}