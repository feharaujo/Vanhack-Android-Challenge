package com.felipearaujo.vanhack.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.helper.ErrorType
import dagger.android.AndroidInjection

/**
 * Created by felipearaujo on 17/03/18.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : AppCompatActivity(), BaseContract.View {

    abstract var presenter: P

    private val lifecycleRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        // Performe injection
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(BaseViewModel<V, P>()::class.java)
        viewModel.presenter = initPresenter()

        presenter = viewModel.presenter as P
        presenter.onAttachView(this as V)
        presenter.onAttachLifecycle(lifecycle)
        presenter.onPresenterCreated()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetachLifecycle(lifecycle)
        presenter.onDetachView()
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    abstract fun initPresenter(): P

    fun getErrorMessage(errorType: ErrorType): String {
        return when(errorType) {
                    ErrorType.INVALID_FORM -> getString(R.string.message_error_empty_form)
                    ErrorType.UNKNOWN -> getString(R.string.error_general)
                }
    }

}