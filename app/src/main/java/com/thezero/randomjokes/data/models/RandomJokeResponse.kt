package com.thezero.randomjokes.data.models

data class RandomJokeResponse(
    val error: Boolean?,
    val amount: Int?,
    val jokes: List<Joke>
)
