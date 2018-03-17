package com.felipearaujo.vanhack.customer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import com.felipearaujo.data.common.isValidEmailAddress
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.vanhack.base.BasePresenter
import com.felipearaujo.vanhack.helper.ErrorType
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by felipearaujo on 17/03/18.
 */

@Suppress("UNCHECKED_CAST")
class CustomerPresenter
constructor(
        override var view: CustomerContract.View?,
        private val dataRepository: CustomerRepository,
        private val appContext: Context
) : BasePresenter<CustomerContract.View>(), CustomerContract.Presenter {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun createAcc() {
        view?.openCreateAccScreen()
    }

    override fun doLogin(email: String, password: String) {
        if (email.isEmpty() || !email.isValidEmailAddress() || password.isEmpty()) {
            view?.showError(ErrorType.INVALID_FORM)
            view?.showLoginInputContainer()
            return
        }

        view?.showLoading()

        disposeBag.addAll(
                dataRepository.doLogin(email, password)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            view?.showLoginInputContainer()
                            view?.openDashboardScreen()
                        }, {
                            view?.showError(ErrorType.UNKNOWN)
                            view?.showLoginInputContainer()
                        })
        )

    }

}
