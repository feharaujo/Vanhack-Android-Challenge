package com.felipearaujo.vanhack.createacc

import android.content.Context
import com.felipearaujo.data.common.isValidEmailAddress
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.model.Customer
import com.felipearaujo.vanhack.base.BasePresenter
import com.felipearaujo.vanhack.helper.ErrorType
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipearaujo on 17/03/18.
 */
class CreateAccountPresenter constructor(
        override var view: CreateAccountContract.View?,
        private val dataRepository: CustomerRepository,
        private val appContext: Context
) : BasePresenter<CreateAccountContract.View>(), CreateAccountContract.Presenter {

    override fun submitAccountData(name: String, email: String, address: String, password: String) {
        if (name.isEmpty() || email.isEmpty() || !email.isValidEmailAddress()
                || address.isEmpty() || password.isEmpty()) {
            view?.accountCreationFailed(ErrorType.INVALID_FORM)
            return
        }

        val customer = Customer(0, email, name, address, getCurrentDate(), password)

        dataRepository.createAccount(customer)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view?.accountCreatedWithSuccess()
                }, {
                    view?.accountCreationFailed(ErrorType.UNKNOWN)
                })
    }

    private fun getCurrentDate(): String {
        val format2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return format2.format(Date())
    }


}