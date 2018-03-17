package com.felipearaujo.data.customer

import com.felipearaujo.data.customer.local.CustomerLocalRepository
import com.felipearaujo.data.customer.remote.CustomerRemoteRepository
import com.felipearaujo.model.Customer
import io.reactivex.Completable

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerRepositoryImpl(
        val remote: CustomerRemoteRepository,
        val local: CustomerLocalRepository
): CustomerRepository {

    // TODO : LOCAL CACHE

    override fun createAccount(customer: Customer): Completable {
       return remote.createAccount(customer)
    }

    override fun doLogin(email: String, password: String): Completable {
        return remote.doLogin(email, password)
    }
}