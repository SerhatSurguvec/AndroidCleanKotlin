package com.serhatsurguvec.androidcleankotlin.layers.data.network

import android.content.Context
import com.tientun.mockresponse.FakeInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ExampleService @Inject constructor(context: Context) {
    val api: ExampleApi by lazy<ExampleApi> {
        val client = OkHttpClient.Builder()
                .addInterceptor(FakeInterceptor(context))
                .build()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://mock.api")
                .client(client)
                .build()

        retrofit.create(ExampleApi::class.java)
    }
}