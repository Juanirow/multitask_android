package mx.juanma.multitask.modules.EditCategory

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Matchers.any

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 11/10/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EditCategoryPresenterTest {

    @Mock lateinit var mView: IEditCategoryView
    @Mock lateinit var mInteractor: IEditCategoryInteractor
    lateinit var mPresenter: EditCategoryPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mPresenter = EditCategoryPresenter(mView, mInteractor)
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mView, mInteractor)
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
        val captor = ArgumentCaptor.forClass(IEditCategoryInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getName()).thenReturn("Deporte")
        Mockito.`when`(this.mView.getDefaultTime()).thenReturn(60)

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(this.mView).getDefaultTime()
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
        val captor = ArgumentCaptor.forClass(IEditCategoryInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getName()).thenReturn("Deporte")
        Mockito.`when`(this.mView.getDefaultTime()).thenReturn(60)

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(this.mView).getDefaultTime()
        Mockito.verify(mView).showProgressView()
        Mockito.verify(mInteractor).addNewCategory(any(), captor.capture())

        captor.value.onCategoryUpdate()
        Mockito.verify(mView).dismissProgressDialog()
        Mockito.verify(mView).closeActivityWithOkResult()
    }

    @Test
    fun shouldShowInternalServerError() {
        val captor = ArgumentCaptor.forClass(IEditCategoryInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getName()).thenReturn("Deporte")
        Mockito.`when`(this.mView.getDefaultTime()).thenReturn(60)

        this.mPresenter.onClickSave()
        Mockito.verify(this.mView).getName()
        Mockito.verify(this.mView).getDefaultTime()
        Mockito.verify(mView).showProgressView()
        Mockito.verify(mInteractor).addNewCategory(any(), captor.capture())

        captor.value.onInternalServerError()
        Mockito.verify(mView).dismissProgressDialog()
        Mockito.verify(mView).showInternalServerError()
    }
}