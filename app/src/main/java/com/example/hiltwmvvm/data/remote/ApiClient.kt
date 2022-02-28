package com.example.hiltwmvvm.data.remote

import com.example.hiltwmvvm.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun movieApi(): MovieApi {
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(MovieApi::class.java)
}