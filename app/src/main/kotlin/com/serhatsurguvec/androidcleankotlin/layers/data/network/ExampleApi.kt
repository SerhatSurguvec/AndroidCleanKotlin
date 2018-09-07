package com.serhatsurguvec.androidcleankotlin.layers.data.network

import retrofit2.Call
import retrofit2.http.POST

interface ExampleApi {

    @POST("examples")
    fun getExamples(): Call<List<ExampleEntity>>
}