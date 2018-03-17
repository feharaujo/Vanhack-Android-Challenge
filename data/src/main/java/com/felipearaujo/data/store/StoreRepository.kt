package com.felipearaujo.data.store

import com.felipearaujo.model.Product
import com.felipearaujo.model.Store
import io.reactivex.Single

/**
 * Created by felipearaujo on 17/03/18.
 */
interface StoreRepository {

    fun fetchStoresWithProducts() : Single<Pair<Store, List<Product>>>

}