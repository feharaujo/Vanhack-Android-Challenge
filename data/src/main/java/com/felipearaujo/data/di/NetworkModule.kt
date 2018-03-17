package com.felipearaujo.data.di

import android.content.Context
import android.content.SharedPreferences
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.felipearaujo.data.URL_BASE
import com.felipearaujo.data.customer.CustomerRepository
import com.felipearaujo.data.customer.CustomerRepositoryImpl
import com.felipearaujo.data.customer.local.CustomerLocalRepository
import com.felipearaujo.data.customer.local.CustomerLocalRepositoryImpl
import com.felipearaujo.data.customer.remote.CustomerRemoteRepository
import com.felipearaujo.data.customer.remote.CustomerRemoteRepositoryImp
import com.felipearaujo.data.customer.remote.CustomerService
import com.felipearaujo.data.store.StoreRepository
import com.felipearaujo.data.store.StoreRepositoryImpl
import com.felipearaujo.data.store.remote.StoreRemoteRepository
import com.felipearaujo.data.store.remote.StoreRemoteRepositoryImpl
import com.felipearaujo.data.store.remote.StoreService
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

/**
 * Created by felipearaujo on 17/03/18.
 */


@Module
class NetworkModule {

    /*@Provides
    @Singleton
    fun providesAuthInterceptor() = BasicAuthInterceptor(USERNAME, PASSWORD)*/

    @Provides
    @Singleton
    fun providesOKHttpClient(/*interceptor: BasicAuthInterceptor*/) = OkHttpClient.Builder()
            .build()


    @Provides
    @Singleton
    fun providesJacksonConverter() =
            JacksonConverterFactory.create(
                    jacksonObjectMapper().registerModule(KotlinModule())
            )


    @Provides
    @Singleton
    fun providesRetrofit(jackson: JacksonConverterFactory, client: OkHttpClient): Retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(jackson)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(URL_BASE)
            .build()


    @Provides
    @Singleton
    fun providesPicasso(context: Context): Picasso =
            Picasso.Builder(context)
                    .loggingEnabled(true)
                    .build()

    /**
     * Repository (local and remote)
     */
    @Provides
    @Singleton
    fun providesCustomerRepository(
            remote: CustomerRemoteRepository,
            local: CustomerLocalRepository
    ): CustomerRepository = CustomerRepositoryImpl(remote, local)

    /**
     * Remote repository
     */
    @Provides
    @Singleton
    fun providesCustomerRemoteRepository(
            service: CustomerService,
            local: CustomerLocalRepository
    ): CustomerRemoteRepository = CustomerRemoteRepositoryImp(service, local)

    /**
     * Local repository
     */
    @Provides
    @Singleton
    fun providesLocalRepository(
            preferences: SharedPreferences
    ): CustomerLocalRepository = CustomerLocalRepositoryImpl(preferences)


    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): CustomerService = retrofit.create(CustomerService::class.java)

    @Provides
    @Singleton
    fun providesPreferences(appContext: Context): SharedPreferences {
        return appContext.getSharedPreferences("DEFAULT_PREFERENCES", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesStoreRemoteRepository(storeService: StoreService): StoreRemoteRepository = StoreRemoteRepositoryImpl(storeService)

    @Provides
    @Singleton
    fun providesStoreRepository(storeRemoteRepository: StoreRemoteRepository): StoreRepository =
            StoreRepositoryImpl(storeRemoteRepository)

    @Provides
    @Singleton
    fun providesStoreService(retrofit: Retrofit): StoreService = retrofit.create(StoreService::class.java)

}