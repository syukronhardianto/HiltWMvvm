package com.example.hiltwmvvm.data.remote

import com.example.hiltwmvvm.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularList(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): MovieResponse
}