package com.felipearaujo.data.customer.local

import android.content.SharedPreferences
import com.felipearaujo.model.Customer
import io.reactivex.Completable


/**
 * Created by felipearaujo on 17/03/18.
 *
 * Best approach : Use a database (Room, Realm)
 * For simplicity a SharedPreferences will be used
 */
class CustomerLocalRepositoryImpl(private val preferences: SharedPreferences) : CustomerLocalRepository {

    // TODO : Implement local cache

    override fun doLogin(email: String, password: String): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createAccount(customer: Customer): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}