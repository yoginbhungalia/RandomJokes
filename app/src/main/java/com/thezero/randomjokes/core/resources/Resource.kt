package com.thezero.randomjokes.core.resources

data class Resource<T>(val status: Status, val data: T?, val errorMessage: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

        fun <T> error(errorMessage: String?): Resource<T> {
            return Resource(Status.ERROR, null, errorMessage)
        }
    }
}
