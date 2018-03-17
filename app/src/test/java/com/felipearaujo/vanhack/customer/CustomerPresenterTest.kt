package com.felipearaujo.vanhack.customer

import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.vanhack.BaseTest
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
import io.reactivex.Completable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Created by felipearaujo on 17/03/18.
 */
@RunWith(JUnit4::class)
class CustomerPresenterTest: BaseTest() {

    @Mock
    lateinit var view: CustomerContract.View
    @Mock
    lateinit var repository: CustomerRepository

    private val presenter: CustomerPresenter by lazy {
        CustomerPresenter(view, repository)
    }

    @Before
    override fun setUp() {
        super.setUp()
    }

    @After
    override fun after() {
        super.after()
    }

    @Test
    fun createAcc() {
        presenter.createAcc()

        Mockito.verify(view, Mockito.times(1)).openCreateAccScreen()
    }

    @Test
    fun doLoginWithSuccess() {
        Mockito.doReturn(
                Completable.complete()
        ).`when`(repository).doLogin(anyString(), anyString())

        presenter.doLogin("test@test.com", "12345678")

        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).hideLoading()

        Mockito.verify(view, Mockito.times(1)).showLoginInputContainer()
        Mockito.verify(view, Mockito.times(1)).hideLoginInputContainer()

        Mockito.verify(view, Mockito.times(1)).openDashboardScreen()
    }

    @Test
    fun doLoginFail() {
        Mockito.doReturn(
                Completable.error(Throwable(Exception()))
        ).`when`(repository).doLogin(anyString(), anyString())

        presenter.doLogin("test@test.com", "12345678")

        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).hideLoading()

        Mockito.verify(view, Mockito.times(1)).showLoginInputContainer()
        Mockito.verify(view, Mockito.times(1)).hideLoginInputContainer()

        Mockito.verify(view, Mockito.times(1)).showError(ErrorTypeEnum.UNKNOWN)

    }

    @Test
    fun formValidationFail() {
        Mockito.doReturn(
                Completable.error(Throwable(Exception()))
        ).`when`(repository).doLogin(anyString(), anyString())

        presenter.doLogin("", "")

        Mockito.verify(view, Mockito.times(1)).showError(ErrorTypeEnum.INVALID_FORM)
    }

}