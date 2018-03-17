package com.felipearaujo.vanhack.createacc

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.felipearaujo.data.common.isValidEmailAddress
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.model.Customer
import com.felipearaujo.vanhack.base.BasePresenter
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipearaujo on 17/03/18.
 */
class CreateAccountPresenter constructor(
        override var view: CreateAccountContract.View?,
        private val dataRepository: CustomerRepository
) : BasePresenter<CreateAccountContract.View>(), CreateAccountContract.Presenter {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun submitAccountData(name: String, email: String, address: String, password: String) {
        if (name.isEmpty() || email.isEmpty() || !email.isValidEmailAddress()
                || address.isEmpty() || password.isEmpty()) {
            view?.showAccountCreationFailedMessage(ErrorTypeEnum.INVALID_FORM)
            return
        }

        val customer = Customer(0, email, name, address, getCurrentDate(), password)
        requestCreateAcc(customer)
    }

    private fun requestCreateAcc(customer: Customer) {
        disposeBag.addAll(
                dataRepository.createAccount(customer)
                        .subscribeOn(Schedulers.trampoline())
                        .observeOn(Schedulers.trampoline())
                        .doOnSubscribe {
                            view?.showLoading()
                            view?.hideForm()
                        }
                        .subscribe({
                            view?.accountCreatedWithSuccess()
                        }, {
                            view?.showForm()
                            view?.hideLoading()
                            view?.showAccountCreationFailedMessage(ErrorTypeEnum.UNKNOWN)
                        })
        )
    }

    private fun getCurrentDate(): String {
        val format2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return format2.format(Date())
    }

}