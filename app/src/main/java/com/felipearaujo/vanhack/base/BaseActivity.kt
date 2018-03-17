package com.felipearaujo.vanhack.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.felipearaujo.vanhack.R
import com.felipearaujo.vanhack.helper.ErrorTypeEnum
import com.felipearaujo.vanhack.helper.EventTypeEnum
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

    fun getErrorMessage(errorTypeEnum: ErrorTypeEnum): String {
        return when(errorTypeEnum) {
                    ErrorTypeEnum.INVALID_FORM -> getString(R.string.message_error_empty_form)
                    ErrorTypeEnum.UNKNOWN -> getString(R.string.error_general)
                }
    }

    fun getGeneralMessage(typeEnum: EventTypeEnum): String {
        return when(typeEnum) {
            EventTypeEnum.ACCOUNT_CREATED_SUCCESS -> getString(R.string.message_account_created_success)
        }
    }
}