package com.thezero.randomjokes.core.dataresponse

class DataFailed<T> (errorMessage: String?): DataResponse<T>(null, errorMessage)