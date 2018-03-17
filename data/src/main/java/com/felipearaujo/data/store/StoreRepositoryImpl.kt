package com.felipearaujo.data.store

import com.felipearaujo.data.store.remote.StoreRemoteRepository
import com.felipearaujo.model.Product
import com.felipearaujo.model.Store
import io.reactivex.Single

/**
 * Created by felipearaujo on 17/03/18.
 */
class StoreRepositoryImpl(val storeRemoteRepository: StoreRemoteRepository): StoreRepository {
    override fun fetchStoresWithProducts(): Single<Pair<Store, List<Product>>> {
        return storeRemoteRepository.fetchStoresWithProducts()
    }
}