package com.serhatsurguvec.androidcleankotlin.core.di

import android.content.Context
import com.serhatsurguvec.androidcleankotlin.core.platform.NetworkHandler
import com.serhatsurguvec.androidcleankotlin.features.example.ExampleApi
import com.serhatsurguvec.androidcleankotlin.features.example.ExampleRepository
import com.tientun.mockresponse.FakeInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(context: Context) = OkHttpClient.Builder()
            .addInterceptor(FakeInterceptor(context))
            .build()

    @Singleton
    @Provides
    fun providesExampleApi(retrofit: Retrofit): ExampleApi {
        return retrofit.create(ExampleApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient) = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://mock.api")
            .client(client)
            .build()

    @Singleton
    @Provides
    fun providesExampleRepository(networkHandler: NetworkHandler,
                                  exampleApi: ExampleApi): ExampleRepository = ExampleRepository.Network(networkHandler, exampleApi)
}

/*
@Module
object AppModule {

    @JvmStatic
    @Provides
    fun providesOkHttpClient(context: Context) = OkHttpClient.Builder()
            .addInterceptor(FakeInterceptor(context))
            .build()

    @JvmStatic
    @Provides
    fun providesExampleApi(retrofit: Retrofit): ExampleApi {
        return retrofit.create(ExampleApi::class.java)
    }

    @JvmStatic
    @Provides
    fun providesRetrofit(client: OkHttpClient) = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://mock.api")
            .client(client)
            .build()

    @JvmStatic
    @Provides
    fun providesExampleRepository(networkHandler: NetworkHandler,
                                  exampleApi: ExampleApi): ExampleRepository = ExampleRepository.Network(networkHandler, exampleApi)
}*/
