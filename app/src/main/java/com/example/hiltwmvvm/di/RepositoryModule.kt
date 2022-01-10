package com.example.hiltwmvvm.di

import com.example.hiltwmvvm.data.remote.MovieApi
import com.example.hiltwmvvm.domain.repository.MovieRepository
import com.example.hiltwmvvm.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(repositoryImpl: MovieRepositoryImpl): MovieRepository
}