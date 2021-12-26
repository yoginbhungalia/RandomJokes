package com.thezero.randomjokes.data.remotedatasource

import com.thezero.randomjokes.data.models.RandomJokeResponse
import retrofit2.Response
import javax.inject.Inject

class JokesApiHelper @Inject constructor(private val apiService: JokesApiService) {
    suspend fun getRandomJokes(amount: Int): Response<RandomJokeResponse> = apiService.getRandomJokes(amount)
}