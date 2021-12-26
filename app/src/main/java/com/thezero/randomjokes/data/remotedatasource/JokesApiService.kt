package com.thezero.randomjokes.data.remotedatasource

import com.thezero.randomjokes.data.models.RandomJokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApiService {
    @GET("joke/Any")
    suspend fun getRandomJokes(@Query("amount") amount: Int): Response<RandomJokeResponse>
}