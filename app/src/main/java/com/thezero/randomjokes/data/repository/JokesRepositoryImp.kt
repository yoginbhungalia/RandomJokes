package com.thezero.randomjokes.data.repository

import com.thezero.randomjokes.core.constants.Constants
import com.thezero.randomjokes.data.models.Joke
import com.thezero.randomjokes.data.remotedatasource.JokesApiHelper
import com.thezero.randomjokes.core.dataresponse.DataFailed
import com.thezero.randomjokes.core.dataresponse.DataResponse
import com.thezero.randomjokes.core.dataresponse.DataSuccess
import com.thezero.randomjokes.domain.repository.JokesRepository
import javax.inject.Inject

class JokesRepositoryImp @Inject constructor(private val jokesApiHelper: JokesApiHelper): JokesRepository {
    override suspend fun getRandomTenJokes(): DataResponse<List<Joke>> {
        val response = jokesApiHelper.getRandomJokes(Constants.NO_OF_JOKES)
        if (response.code() == 200) {
            response.body()?.let {
                return DataSuccess(it.jokes)
            }
        }

        return DataFailed("Failed for some reason! Proper error reasons and response codes are not handled!")
    }
}