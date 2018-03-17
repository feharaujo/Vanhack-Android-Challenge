package com.felipearaujo.data.store.remote

import com.felipearaujo.model.Store
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by felipearaujo on 17/03/18.
 */
interface StoreService {

    @GET("/api/v1/Store")
    fun getStores(): Single<List<Store>>


}