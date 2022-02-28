package com.example.hiltwmvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.data.remote.MoviePagingSource
import com.example.hiltwmvvm.data.remote.movieApi
import com.example.hiltwmvvm.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {

    private val movieApi = movieApi()

    override fun getMovies(): LiveData<PagingData<MovieData>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi)
            }
        ).liveData
}