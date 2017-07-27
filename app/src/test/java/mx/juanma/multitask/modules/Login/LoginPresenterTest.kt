package mx.juanma.multitask.modules.Login

import org.junit.After
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito

import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class LoginPresenterTest {

    @Mock
    lateinit var mView: ILoginView

    lateinit var mPresenter: LoginPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mPresenter = LoginPresenter(this.mView)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(this.mView)
    }
}