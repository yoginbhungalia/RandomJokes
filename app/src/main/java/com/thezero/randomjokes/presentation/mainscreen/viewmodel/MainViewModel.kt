package com.thezero.randomjokes.presentation.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thezero.randomjokes.core.resources.Resource
import com.thezero.randomjokes.core.dataresponse.DataSuccess
import com.thezero.randomjokes.domain.usecases.GetRandomTenJokesUseCase
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val getRandomTenJokesUseCase: GetRandomTenJokesUseCase): ViewModel() {
    fun fetchRandomTenJokes() = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            val dataResponse = getRandomTenJokesUseCase.invoke()
            if (dataResponse is DataSuccess) {
                emit(Resource.success(dataResponse.data))
            } else {
                emit(Resource.error(dataResponse.error))
            }
        } catch (exception: Exception) {
            emit(Resource.error(exception.message ?: "Error Occurred!"))
        }
    }
}