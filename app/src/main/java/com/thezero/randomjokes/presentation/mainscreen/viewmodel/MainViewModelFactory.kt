package com.thezero.randomjokes.presentation.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thezero.randomjokes.domain.usecases.GetRandomTenJokesUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val getRandomTenJokesUseCase: GetRandomTenJokesUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getRandomTenJokesUseCase) as T
    }
}