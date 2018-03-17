package com.felipearaujo.data.customer.remote

import com.felipearaujo.model.Customer
import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by felipearaujo on 17/03/18.
 */
interface CustomerService {

    @POST("/api/v1/Customer")
    fun createAccount(@Body customer: Customer) : Completable

    @POST("/api/v1/Customer/auth")
    fun login() : Completable


}