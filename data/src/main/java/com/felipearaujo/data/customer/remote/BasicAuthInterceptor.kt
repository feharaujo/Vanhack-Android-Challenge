package com.felipearaujo.data.customer.remote

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by felipearaujo on 17/03/18.
 */
class BasicAuthInterceptor(private val username: String, private val password: String) : Interceptor {

    private val credentials: String by lazy {
        Credentials.basic(username, password)
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
            val request = chain?.request()
            val authenticatedRequest = request?.newBuilder()
                    ?.header("Authorization", credentials)
                    ?.build()


        return chain?.proceed(authenticatedRequest)!!
    }

}