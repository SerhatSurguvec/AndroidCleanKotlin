package com.serhatsurguvec.androidcleankotlin.features.example

import retrofit2.Call
import retrofit2.http.POST

interface ExampleApi {

    @POST("examples")
    fun getExamples(): Call<List<ExampleEntity>>
}