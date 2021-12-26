package com.thezero.randomjokes.presentation.splashscreen.viewmodel

import com.google.common.truth.Truth
import org.junit.Before

import org.junit.Test

class SplashViewModelTest {

    private lateinit var splashViewModel: SplashViewModel

    @Before
    fun setup() {
        splashViewModel = SplashViewModel()
    }

    @Test
    fun incrementAppOpenCounterByOne_returnTrue() {
        val initialCount = (0..100).random()
        val result = splashViewModel.incrementAppOpenCounter(initialCount)
        Truth.assertThat(result).isEqualTo(initialCount + 1)
    }

}