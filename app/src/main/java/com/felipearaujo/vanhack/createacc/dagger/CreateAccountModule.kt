package com.felipearaujo.vanhack.createacc.dagger

import android.content.Context
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.vanhack.createacc.CreateAccountActivity
import com.felipearaujo.vanhack.createacc.CreateAccountContract
import com.felipearaujo.vanhack.createacc.CreateAccountPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 17/03/18.
 */
@Module
class CreateAccountModule {

    @Provides
    fun providesView(activity: CreateAccountActivity): CreateAccountContract.View = activity

    @Provides
    fun providesPresenter(
            view: CreateAccountContract.View,
            dataRepository: CustomerRepository,
            context: Context
    ): CreateAccountContract.Presenter = CreateAccountPresenter(view, dataRepository, context)

}