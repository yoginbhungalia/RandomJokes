package com.thezero.randomjokes.presentation.splashscreen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thezero.randomjokes.app.RandomJokesApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    companion object {
        private const val SPLASH_SCREEN_TIMEOUT_IN_MILLI_SECONDS = 3000L
    }

    val applicationInitialized = MutableLiveData<Boolean>()

    fun initializeApplication() {
        viewModelScope.launch {
            delay(SPLASH_SCREEN_TIMEOUT_IN_MILLI_SECONDS)

            // update application opened counter
            updateAppNoOfTimesAppOpenCounter()

            applicationInitialized.value = true
        }
    }

    private fun updateAppNoOfTimesAppOpenCounter() {
        // increase counter which defines how many times app was opened
        RandomJokesApp.localPreference?.let {
            it.noOfTimesAppOpens = incrementAppOpenCounter(it.noOfTimesAppOpens)
        }
    }

    fun incrementAppOpenCounter(currentAppOpenCounter: Int): Int {
        return currentAppOpenCounter + 1
    }
}