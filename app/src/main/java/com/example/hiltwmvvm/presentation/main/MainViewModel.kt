package com.example.hiltwmvvm.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hiltwmvvm.domain.use_case.GetMovieListUseCase

class MainViewModel : ViewModel() {

    private val getMovieListUseCase = GetMovieListUseCase()

    val movies = getMovieListUseCase.invoke().cachedIn(viewModelScope)
}