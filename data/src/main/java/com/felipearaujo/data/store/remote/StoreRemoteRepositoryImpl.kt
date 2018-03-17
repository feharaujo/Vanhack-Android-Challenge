package com.felipearaujo.data.store.remote

import com.felipearaujo.model.Product
import com.felipearaujo.model.Store
import io.reactivex.Single

/**
 * Created by felipearaujo on 17/03/18.
 */
class StoreRemoteRepositoryImpl(storeService: StoreService): StoreRemoteRepository {

    override fun fetchStoresWithProducts(): Single<Pair<Store, List<Product>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // time over :(
    }


}