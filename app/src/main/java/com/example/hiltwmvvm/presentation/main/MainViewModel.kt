package com.example.hiltwmvvm.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hiltwmvvm.domain.use_case.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    val movies = getMovieListUseCase.invoke().cachedIn(viewModelScope)
}