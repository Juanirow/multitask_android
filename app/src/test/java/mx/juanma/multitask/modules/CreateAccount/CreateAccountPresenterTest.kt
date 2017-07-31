package mx.juanma.multitask.modules.CreateAccount

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Matchers.anyString

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 31/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class CreateAccountPresenterTest {

    @Mock
    lateinit var mView: ICreateAccountView

    @Mock
    lateinit var mInteractor: ICreateAccountInteractor

    lateinit var mPresenter: CreateAccountPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        this.mPresenter = CreateAccountPresenter(mView, mInteractor)
        Mockito.verifyNoMoreInteractions(mView, mInteractor)
    }

    @Test
    fun shouldShowErrorWhenEmailIsEmpty() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("")

        mPresenter.onClickCreateAccount()
        Mockito.verify(mView).getEmail()

        Mockito.verify(this.mView).showEmailRequiredError()
    }

    @Test
    fun shouldShowErrorWhenEmailInvalid() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah")

        mPresenter.onClickCreateAccount()
        Mockito.verify(mView).getEmail()

        Mockito.verify(this.mView).showEmailInvalidError()
    }

    @Test
    fun shouldShowErrorPasswordRequired() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("")

        mPresenter.onClickCreateAccount()
        Mockito.verify(mView).getEmail()
        Mockito.verify(mView).getPassword()

        Mockito.verify(this.mView).showPasswordRequiredError()
    }

    @Test
    fun shouldShowErrorPasswordWrongLength() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("12345")

        mPresenter.onClickCreateAccount()
        Mockito.verify(mView).getEmail()
        Mockito.verify(mView).getPassword()

        Mockito.verify(this.mView).showPasswordWrongLengthError()
    }

    @Test
    fun shouldShowErrorPasswordNotMatch() {
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")
        Mockito.`when`(this.mView.getPasswordAgain()).thenReturn("123")

        mPresenter.onClickCreateAccount()
        Mockito.verify(mView).getEmail()
        Mockito.verify(mView).getPassword()
        Mockito.verify(mView).getPasswordAgain()

        Mockito.verify(this.mView).showPasswordNotMatchError()
    }

    @Test
    fun shouldShowErrorServer() {
        val captor = ArgumentCaptor.forClass(ICreateAccountInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")
        Mockito.`when`(this.mView.getPasswordAgain()).thenReturn("123456")

        mPresenter.onClickCreateAccount()

        Mockito.verify(mView).getEmail()
        Mockito.verify(mView).getPassword()
        Mockito.verify(mView).getPasswordAgain()
        Mockito.verify(this.mView).showProgressDialog()
        Mockito.verify(this.mInteractor).createAccount(anyString(), anyString(), captor.capture())

        captor.value.onCreateAccountServerError()
        Mockito.verify(this.mView).hideProgressDialog()
        Mockito.verify(this.mView).showServerError()
    }

    @Test
    fun shouldShowErrorUserAlreadyInUse() {
        val captor = ArgumentCaptor.forClass(ICreateAccountInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")
        Mockito.`when`(this.mView.getPasswordAgain()).thenReturn("123456")

        mPresenter.onClickCreateAccount()

        Mockito.verify(mView).getEmail()
        Mockito.verify(mView).getPassword()
        Mockito.verify(mView).getPasswordAgain()
        Mockito.verify(this.mView).showProgressDialog()
        Mockito.verify(this.mInteractor).createAccount(anyString(), anyString(), captor.capture())

        captor.value.onUserAlreadyInUse()
        Mockito.verify(this.mView).hideProgressDialog()
        Mockito.verify(this.mView).showUserAlreadyInUserError()
    }

    @Test
    fun shouldCloseActivityOKResultWhenCreateAccountIsSucceed() {
        val captor = ArgumentCaptor.forClass(ICreateAccountInteractor.Callback::class.java)
        Mockito.`when`(this.mView.getEmail()).thenReturn("nailah@mail.com")
        Mockito.`when`(this.mView.getPassword()).thenReturn("123456")
        Mockito.`when`(this.mView.getPasswordAgain()).thenReturn("123456")

        mPresenter.onClickCreateAccount()

        Mockito.verify(mView).getEmail()
        Mockito.verify(mView).getPassword()
        Mockito.verify(mView).getPasswordAgain()
        Mockito.verify(this.mView).showProgressDialog()
        Mockito.verify(this.mInteractor).createAccount(anyString(), anyString(), captor.capture())

        captor.value.onCreateAccountSuccess()
        Mockito.verify(this.mView).hideProgressDialog()
        Mockito.verify(this.mView).closeActivityWithOkResult()
    }

}