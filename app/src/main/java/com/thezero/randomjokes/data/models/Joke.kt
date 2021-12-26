package com.thezero.randomjokes.data.models

data class Joke(
    val id: Int?,
    val safe: Boolean?,
    val lang: String?,
    val category: String?,
    val type: String?,
    val joke: String?,
    val setup: String?,
    val delivery: String?,
)
