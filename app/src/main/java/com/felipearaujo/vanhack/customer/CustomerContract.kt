package com.felipearaujo.vanhack.customer

import com.felipearaujo.vanhack.base.BaseContract
import com.felipearaujo.vanhack.helper.ErrorType

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerContract {

    interface View : BaseContract.View {

        fun openCreateAccScreen()

        fun openDashboardScreen()

        fun showError(message: ErrorType)

        fun showLoginInputContainer()

        fun showLoading()

    }

    interface Presenter: BaseContract.Presenter<CustomerContract.View> {

        fun createAcc()

        fun doLogin(email: String, password: String)

    }

}