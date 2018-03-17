package com.felipearaujo.data.customer.remote

import com.felipearaujo.model.Customer
import io.reactivex.Completable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * Created by felipearaujo on 17/03/18.
 */
interface CustomerService {

    @POST("/api/v1/Customer")
    fun createAccount(@Body customer: Customer): Completable

    @Multipart
    @POST("/api/v1/Customer/auth")
    fun login(@Part("email") email: RequestBody, @Part("password") password: RequestBody): Completable


}