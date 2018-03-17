package com.felipearaujo.vanhack.di

import com.felipearaujo.vanhack.customer.CustomerActivity
import com.felipearaujo.vanhack.customer.dagger.CustomerModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 17/03/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [CustomerModule::class])
    abstract fun bindProjectsActivity(): CustomerActivity


}