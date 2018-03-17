package com.felipearaujo.data.customer.remote

import com.felipearaujo.data.customer.local.CustomerLocalRepository
import com.felipearaujo.model.Customer
import io.reactivex.Completable

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerRemoteRepositoryImp(
        private val service: CustomerService,
        private val localRepository: CustomerLocalRepository
) : CustomerRemoteRepository {

    override fun doLogin(email: String, password: String): Completable {
        return service.login()
    }

    override fun createAccount(customer: Customer): Completable {
        return service.createAccount(customer)
    }

}