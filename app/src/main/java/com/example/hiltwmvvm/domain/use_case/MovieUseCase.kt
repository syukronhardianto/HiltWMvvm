package com.example.hiltwmvvm.domain.use_case

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.hiltwmvvm.data.model.MovieData

interface MovieUseCase {
    operator fun invoke(): LiveData<PagingData<MovieData>>
}