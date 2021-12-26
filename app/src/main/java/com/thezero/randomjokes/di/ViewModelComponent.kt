package com.thezero.randomjokes.di

import com.thezero.randomjokes.presentation.mainscreen.view.MainActivity
import dagger.Component

@Component (modules = [JokesRepositoryModule::class, JokesApiServiceModule::class])
interface ViewModelComponent {
    fun inject(mainActivity: MainActivity)
}