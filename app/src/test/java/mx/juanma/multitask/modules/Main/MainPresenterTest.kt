package mx.juanma.multitask.modules.Main

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
class MainPresenterTest {

    @Mock
    lateinit var mView: IMainView

    @Mock
    lateinit var mInteractor: IMainInteractor

    lateinit var mPresenter: MainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = MainPresenter(mView, mInteractor)
    }

    @After
    fun tearDown() {
        Mockito.verifyNoMoreInteractions(mView, mInteractor)
    }

    @Test
    fun shouldCloseActivityOkResult() {
        mPresenter.onClickLogout()

        Mockito.verify(this.mInteractor).logout()
        Mockito.verify(this.mView).finishActivityWithOkResult()
    }

    @Test
    fun shouldLaunchCategoriesActivity() {
        mPresenter.onClickCategories()
        Mockito.verify(this.mView).launchCategoriesActivity()
    }
}