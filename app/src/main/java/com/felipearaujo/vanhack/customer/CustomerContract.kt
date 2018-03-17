package com.felipearaujo.vanhack.customer

import com.felipearaujo.vanhack.base.BaseContract
import com.felipearaujo.vanhack.helper.ErrorTypeEnum

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerContract {

    interface View : BaseContract.View {

        fun openCreateAccScreen()

        fun openDashboardScreen()

        fun showError(errorTypeEnum: ErrorTypeEnum)

        fun showLoginInputContainer()

        fun showLoading()

        fun hideLoginInputContainer()

        fun hideLoading()

    }

    interface Presenter: BaseContract.Presenter<CustomerContract.View> {

        fun createAcc()

        fun doLogin(email: String, password: String)

    }

}