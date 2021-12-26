package com.thezero.randomjokes.di

import com.thezero.randomjokes.data.remotedatasource.JokesApiHelper
import com.thezero.randomjokes.data.repository.JokesRepositoryImp
import com.thezero.randomjokes.domain.repository.JokesRepository
import dagger.Module
import dagger.Provides

@Module
class JokesRepositoryModule {

    @Provides
    fun jokesRepository(jokesApiHelper: JokesApiHelper): JokesRepository = JokesRepositoryImp(jokesApiHelper)
}