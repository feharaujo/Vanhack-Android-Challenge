package com.felipearaujo.data.customer.local

import android.content.SharedPreferences
import io.reactivex.Completable


/**
 * Created by felipearaujo on 17/03/18.
 */

/**
 * Best approach : Use a database (Room, Realm)
 * For simplicity a SharedPreferences will be used
 */
class CustomerLocalRepositoryImpl(private val preferences: SharedPreferences): CustomerLocalRepository {

    override fun doLogin(email: String, password: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createAccount(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*override fun saveCacheData(cache: Single<Response>) {
        cache.observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val mapper = ObjectMapper()
                    val json = mapper.writeValueAsString(it)

                    preferences.edit().putString(RESPONSE_KEY, json).apply()
                }, {
                    it.printStackTrace()
                })
    }

    override fun fetchProjects(): Single<Response> {
        val json = preferences.getString(RESPONSE_KEY, null)

        return if (json == null) {
            Single.error<Response>(Throwable(NetworkErrorException(GENERIC_ERROR_MSG)))
        } else {
            val response = ObjectMapper().readValue(json, Response::class.java)
            Single.just(response)
        }
    }*/

}