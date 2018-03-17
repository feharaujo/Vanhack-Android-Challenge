package com.felipearaujo.vanhack.customer

import com.felipearaujo.vanhack.base.BaseContract

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerContract {

    interface View : BaseContract.View {

        fun openCreateAccScreen()

        fun openDashboardScreen()

        fun showError(message: String)

        fun showLoginInputContainer()

        fun showLoading()

    }

    interface Presenter: BaseContract.Presenter<CustomerContract.View> {

        fun createAcc()

        fun doLogin(email: String, password: String)

    }

}