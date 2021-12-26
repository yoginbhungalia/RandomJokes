package com.thezero.randomjokes.domain.usecases

import com.thezero.randomjokes.data.models.Joke
import com.thezero.randomjokes.core.dataresponse.DataResponse
import com.thezero.randomjokes.domain.repository.JokesRepository
import javax.inject.Inject

class GetRandomTenJokesUseCase @Inject constructor(private val jokesRepository: JokesRepository) {
    suspend operator fun invoke(): DataResponse<List<Joke>> {
        return jokesRepository.getRandomTenJokes()
    }
}