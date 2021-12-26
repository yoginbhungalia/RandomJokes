package com.thezero.randomjokes.data.remotedatasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokesApiBuilder {

    private const val BASE_URL = "https://v2.jokeapi.dev/"

    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val jokesApiService: JokesApiService = getRetrofit().create(JokesApiService::class.java)
}