package com.felipearaujo.data.customer

import com.felipearaujo.data.customer.local.CustomerLocalRepository
import com.felipearaujo.data.customer.remote.CustomerRemoteRepository
import io.reactivex.Completable

/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerRepositoryImpl(
        val remote: CustomerRemoteRepository,
        val local: CustomerLocalRepository
): CustomerRepository {

    override fun createAccount(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doLogin(email: String, password: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}