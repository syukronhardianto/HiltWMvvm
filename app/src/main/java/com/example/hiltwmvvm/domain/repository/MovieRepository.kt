package com.example.hiltwmvvm.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.hiltwmvvm.data.model.MovieData

interface MovieRepository {
    fun getMovies(): LiveData<PagingData<MovieData>>
}