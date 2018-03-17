package com.felipearaujo.vanhack.customer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.vanhack.base.BasePresenter
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

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun createAcc() {
        view?.openCreateAccScreen()
    }

    override fun doLogin(email: String, password: String) {
        // TODO: Validate fields data

        view?.showLoading()

        disposeBag.addAll(
                dataRepository.doLogin(email, password)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            view?.showLoginInputContainer()
                            view?.openDashboardScreen()
                        }, {
                            view?.showError("")
                            view?.showLoginInputContainer()
                        })
        )

    }

    /*override fun fetchProjects(): Disposable {
        return requestProjectsObservable()
                .subscribeBy(onSuccess = {
                    val result = it.projects as List<ProjectsItem>
                    view?.updateProjectsData(result)
                }, onError = {
                    view?.showErrorMessage(GENERIC_ERROR_MSG)
                })

    }

    private fun requestProjectsObservable(): Single<Response> {
        return dataRepository.fetchProjects()
                .doOnSubscribe {
                    view?.showLoading()
                    view?.hideRecyclerView()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterSuccess {
                    view?.hideLoading()
                    view?.showRecyclerView()
                }
                .doOnError {
                    view?.hideLoading()
                    view?.showErrorMessage(GENERIC_ERROR_MSG)
                }
    }*/


}
