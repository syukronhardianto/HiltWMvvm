package com.example.hiltwmvvm.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hiltwmvvm.domain.use_case.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    movieUseCase: MovieUseCase
) : ViewModel() {

    val movies = movieUseCase.invoke().cachedIn(viewModelScope)
}