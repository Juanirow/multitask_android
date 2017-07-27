package mx.juanma.multitask.modules.Login

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Matchers.any
import org.mockito.Matchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify

import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginPresenterTest {

    @Mock
    lateinit var mView: ILoginView

    @Mock
    lateinit var mInteractor: ILoginInteractor

    lateinit var mPresenter: LoginPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mPresenter = LoginPresenter(this.mView, this.mInteractor)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(this.mView)
    }

    @Test
    fun shouldShowErrorWhenTheEmailIsNull() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).showEmailRequiredError()
    }

    @Test
    fun shouldShowErrorWhenTheEmailInvalid() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).showEmailInvalid()
    }

    @Test
    fun shouldShowErrorWhenThePasswordNull() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).getPassword()
        verify(this.mView).showPasswordRequiredError()
    }

    @Test
    fun shouldShowErrorWhenThePasswordHaveLessThan6Characters() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("12345")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).getPassword()
        verify(this.mView).showPasswordWrongLengthError()
    }


    @Test
    fun shouldShowErrorWhenTheServerReturnsError() {
        val captor = ArgumentCaptor.forClass(ILoginInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).getPassword()
        verify(this.mView).showProgressDialog()

        verify(this.mInteractor).signUp(
                anyString(),
                anyString(),
                captor.capture())

        captor.value.onLoginServerError()
        verify(this.mView).hideProgressDialog()
        verify(this.mView).showServerError()
    }

    @Test
    fun shouldShowErrorWhenServerReturnsWrongCredentials() {
        val captor = ArgumentCaptor.forClass(ILoginInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).getPassword()
        verify(this.mView).showProgressDialog()

        verify(this.mInteractor).signUp(
                anyString(),
                anyString(),
                captor.capture())

        captor.value.onWrongCredentials()
        verify(this.mView).hideProgressDialog()
        verify(this.mView).showWrongCredentialsError()
    }

    @Test
    fun shouldCloseActivityWithOkResultWhenLoginSuccessful() {
        val captor = ArgumentCaptor.forClass(ILoginInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")

        this.mPresenter.onLoginBtnClick()

        verify(this.mView).getEmail()
        verify(this.mView).getPassword()
        verify(this.mView).showProgressDialog()

        verify(this.mInteractor).signUp(
                anyString(),
                anyString(),
                captor.capture())

        captor.value.onLoginSuccessful()
        verify(this.mView).hideProgressDialog()
        verify(this.mView).closeActivityWithOkResult()
    }


}