package com.example.hiltwmvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.data.remote.MovieApi
import com.example.hiltwmvvm.domain.repository.MovieRepository
import javax.inject.Inject

class NewRepo @Inject constructor(
    private val movieApi: MovieApi
): MovieRepository {
    override fun getMovies(): LiveData<PagingData<MovieData>> {
        TODO("Not yet implemented")
    }
}