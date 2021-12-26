package com.thezero.randomjokes.domain.repository

import com.thezero.randomjokes.data.models.Joke
import com.thezero.randomjokes.core.dataresponse.DataResponse

interface JokesRepository {
    suspend fun getRandomTenJokes(): DataResponse<List<Joke>>
}