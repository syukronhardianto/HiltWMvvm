package com.example.hiltwmvvm.di

import com.example.hiltwmvvm.domain.repository.MovieRepository
import com.example.hiltwmvvm.domain.use_case.MovieUseCase
import com.example.hiltwmvvm.domain.use_case.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class UseCaseModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}