package com.felipearaujo.vanhack.createacc

import com.felipearaujo.vanhack.base.BaseContract
import com.felipearaujo.vanhack.helper.ErrorType

/**
 * Created by felipearaujo on 17/03/18.
 */
class CreateAccountContract {

    interface View : BaseContract.View {

        fun accountCreatedWithSuccess()

        fun accountCreationFailed(message: ErrorType)

    }

    interface Presenter: BaseContract.Presenter<CreateAccountContract.View> {

        fun submitAccountData(name: String, email: String, address: String, password: String)


    }



}