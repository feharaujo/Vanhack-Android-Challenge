package com.felipearaujo.data.customer.remote

import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.felipearaujo.data.BuildConfig
import com.felipearaujo.data.customer.local.CustomerLocalRepository
import com.felipearaujo.model.Customer
import com.felipearaujo.model.SimpleCustomer
import io.reactivex.Completable
import okhttp3.MediaType
import okhttp3.RequestBody



/**
 * Created by felipearaujo on 17/03/18.
 */
class CustomerRemoteRepositoryImp(
        private val service: CustomerService,
        private val localRepository: CustomerLocalRepository
) : CustomerRemoteRepository {

    override fun doLogin(email: String, password: String): Completable {
        val customer = SimpleCustomer(email, password)

        if(BuildConfig.DEBUG) {
            val mapper = ObjectMapper()
            val json = mapper.writeValueAsString(customer)
            Log.v("Vanhack", json)
        }

        val emailBody = RequestBody.create(MediaType.parse("text/plain"), email)
        val passwordBody = RequestBody.create(MediaType.parse("text/plain"), password)

        return service.login(emailBody, passwordBody)
    }

    override fun createAccount(customer: Customer): Completable {
        return service.createAccount(customer)
    }

}