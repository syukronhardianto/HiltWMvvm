package com.example.hiltwmvvm.domain.use_case

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(): LiveData<PagingData<MovieData>> =
        repository.getMovies()
}