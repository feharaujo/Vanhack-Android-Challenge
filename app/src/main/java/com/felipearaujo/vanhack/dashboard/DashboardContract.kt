package com.felipearaujo.vanhack.dashboard

import com.felipearaujo.vanhack.base.BaseContract
import com.felipearaujo.vanhack.customer.CustomerContract
import com.felipearaujo.vanhack.helper.ErrorTypeEnum

/**
 * Created by felipearaujo on 17/03/18.
 */
class DashboardContract {

    interface View : BaseContract.View {

        fun showError(errorTypeEnum: ErrorTypeEnum)

        fun showData()

        fun showLoading()

        fun hideLoading()

    }

    interface Presenter: BaseContract.Presenter<CustomerContract.View> {



    }


}