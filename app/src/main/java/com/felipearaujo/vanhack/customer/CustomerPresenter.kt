package com.felipearaujo.vanhack.customer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.felipearaujo.data.common.isValidEmailAddress
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.vanhack.base.BasePresenter
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
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
        private val dataRepository: CustomerRepository
) : BasePresenter<CustomerContract.View>(), CustomerContract.Presenter {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun createAcc() {
        view?.openCreateAccScreen()
    }

    override fun doLogin(email: String, password: String) {
        if (email.isEmpty() || !email.isValidEmailAddress() || password.isEmpty()) {
            view?.showError(ErrorTypeEnum.INVALID_FORM)
            return
        }

        disposeBag.addAll(
                dataRepository.doLogin(email, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {
                            view?.showLoading()
                            view?.hideLoginInputContainer()
                        }
                        .doFinally {
                            view?.hideLoading()
                            view?.showLoginInputContainer()
                        }
                        .subscribe({
                            view?.openDashboardScreen()
                        }, {
                            view?.showError(ErrorTypeEnum.UNKNOWN)
                        })
        )

    }

}
