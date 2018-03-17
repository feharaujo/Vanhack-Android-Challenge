package com.felipearaujo.vanhack.createacc

import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.model.Customer
import com.felipearaujo.vanhack.BaseTest
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
import io.reactivex.Completable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Created by felipearaujo on 17/03/18.
 */
@RunWith(JUnit4::class)
class CreateAccountPresenterTest : BaseTest() {

    @Mock
    lateinit var view: CreateAccountContract.View
    @Mock
    lateinit var repository: CustomerRepository

    private val presenter: CreateAccountPresenter by lazy {
        CreateAccountPresenter(view, repository)
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
    fun onFormDataIsInvalid() {
        presenter.submitAccountData("", "", "", "");

        Mockito.verify(view, Mockito.times(1))
                .showAccountCreationFailedMessage(ErrorTypeEnum.INVALID_FORM)
    }

    @Test
    fun onAccountCreationFail() {
        val email = "test@test.com"
        val name = "Felipe"
        val address = "Street x"
        val password = "123456678"

        val customer = Customer(0, email, name, address, "2018-03-17T13:12:45.599Z", password)
        Mockito.doReturn(
                Completable.error(Throwable(Exception()))
        ).`when`(repository).createAccount(customer)

        presenter.submitAccountData(
                name, email, address, password
        )

        Mockito.verify(view, Mockito.times(1)).showLoading()
        Mockito.verify(view, Mockito.times(1)).hideForm()
        Mockito.verify(view, Mockito.times(1))
                .showAccountCreationFailedMessage(ErrorTypeEnum.UNKNOWN)
        Mockito.verify(view, Mockito.times(1)).hideLoading()
        Mockito.verify(view, Mockito.times(1)).showForm()
    }

}