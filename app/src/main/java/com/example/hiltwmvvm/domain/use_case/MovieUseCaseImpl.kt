package com.example.hiltwmvvm.domain.use_case

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.domain.repository.MovieRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MovieUseCase {

    override operator fun invoke(): LiveData<PagingData<MovieData>> =
        repository.getMovies()
}