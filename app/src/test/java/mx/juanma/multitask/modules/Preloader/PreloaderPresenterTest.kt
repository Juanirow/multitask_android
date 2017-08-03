package mx.juanma.multitask.modules.Preloader

import android.app.Activity
import mx.juanma.multitask.Constants
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 03/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class PreloaderPresenterTest {

    @Mock
    lateinit var mView: IPreloaderView

    @Mock
    lateinit var mInteractor: IPreloaderInteractor

    lateinit var mPresenter: PreloaderPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mPresenter = PreloaderPresenter(mView, mInteractor)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(mView, mInteractor)
    }

    @Test
    fun shouldLaunchMainActivityWhenSessionActive() {
        val captor = ArgumentCaptor.forClass(IPreloaderInteractor.Callback::class.java)
        mPresenter.verifyCurrentSession()

        Mockito.verify(this.mInteractor).verifySession(captor.capture())
        captor.value.onActiveSession()

        Mockito.verify(mView).launchMainActivity()
    }

    @Test
    fun shouldLaunchLoginSessionInactive() {
        val captor = ArgumentCaptor.forClass(IPreloaderInteractor.Callback::class.java)
        mPresenter.verifyCurrentSession()

        Mockito.verify(this.mInteractor).verifySession(captor.capture())
        captor.value.onInActiveSession()

        Mockito.verify(mView).launchLoginActivity()
    }

    @Test
    fun shouldLaunchLoginWhenMainActivityCloseWithOkResult() {
        mPresenter.activityResult(Constants.REQUEST_MAIN_ACTIVITY, Activity.RESULT_OK)
        Mockito.verify(mView).launchLoginActivity()
    }

    @Test
    fun shouldCloseActivityWhenMainCloseWithCancelCode() {
        mPresenter.activityResult(Constants.REQUEST_MAIN_ACTIVITY, Activity.RESULT_CANCELED)
        Mockito.verify(mView).closeActivity()
    }

    @Test
    fun shouldCloseActivityWhenLoginCloseWithCancelCode() {
        mPresenter.activityResult(Constants.REQUEST_LOGIN_ACTIVITY, Activity.RESULT_CANCELED)
        Mockito.verify(mView).closeActivity()
    }

    @Test
    fun shouldLaunchMainActivityAfterLoginCloseWithOKResult() {
        val captor = ArgumentCaptor.forClass(IPreloaderInteractor.Callback::class.java)
        mPresenter.activityResult(Constants.REQUEST_LOGIN_ACTIVITY, Activity.RESULT_OK)

        Mockito.verify(this.mInteractor).verifySession(captor.capture())
        captor.value.onActiveSession()

        Mockito.verify(mView).launchMainActivity()
    }
}