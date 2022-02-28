package com.example.hiltwmvvm.domain.use_case

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.data.repository.MovieRepositoryImpl
import com.example.hiltwmvvm.domain.repository.MovieRepository

class GetMovieListUseCase {

    private val repository: MovieRepository = MovieRepositoryImpl()

    operator fun invoke(): LiveData<PagingData<MovieData>> =
        repository.getMovies()
}