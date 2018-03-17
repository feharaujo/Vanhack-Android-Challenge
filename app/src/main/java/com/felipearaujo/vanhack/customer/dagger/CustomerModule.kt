package com.felipearaujo.vanhack.customer.dagger

import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.vanhack.customer.CustomerActivity
import com.felipearaujo.vanhack.customer.CustomerContract
import com.felipearaujo.vanhack.customer.CustomerPresenter
import dagger.Module
import dagger.Provides


/**
 * Created by felipearaujo on 17/03/18.
 */
@Module
class CustomerModule {

    @Provides
    fun providesView(activity: CustomerActivity): CustomerContract.View = activity

    @Provides
    fun providesPresenter(
            view: CustomerContract.View,
            dataRepository: CustomerRepository
    ): CustomerContract.Presenter = CustomerPresenter(view, dataRepository)

}