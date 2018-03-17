package com.felipearaujo.vanhack.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by felipearaujo on 17/03/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: Application): Context = app

}