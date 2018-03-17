package com.felipearaujo.vanhack.di

import android.app.Application
import com.felipearaujo.data.di.NetworkModule
import com.felipearaujo.vanhack.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by felipearaujo on 17/03/18.
 */
@Singleton
@Component(modules = [
    (AppModule::class), (NetworkModule::class), (AndroidInjectionModule::class), (ActivityBuilder::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent

    }

    fun inject(application: AppApplication)

}