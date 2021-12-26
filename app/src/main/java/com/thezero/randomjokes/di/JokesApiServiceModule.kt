package com.thezero.randomjokes.di

import com.thezero.randomjokes.data.remotedatasource.JokesApiBuilder
import com.thezero.randomjokes.data.remotedatasource.JokesApiService
import dagger.Module
import dagger.Provides

@Module
class JokesApiServiceModule {

    @Provides
    fun provideJokesApiService(): JokesApiService = JokesApiBuilder.jokesApiService
}