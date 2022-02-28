package com.example.hiltwmvvm.presentation.main

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class TestClass @Inject constructor() {
    fun provideString() = "ini string"
}