package com.felipearaujo.data.customer

import com.felipearaujo.data.common.BaseRepository
import com.felipearaujo.model.Customer
import io.reactivex.Completable

/**
 * Created by felipearaujo on 17/03/18.
 */
interface CustomerRepository : BaseRepository {

    fun doLogin(email: String, password: String): Completable

    fun createAccount(customer: Customer): Completable

}