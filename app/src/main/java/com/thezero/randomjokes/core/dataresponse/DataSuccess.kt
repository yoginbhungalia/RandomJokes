package com.thezero.randomjokes.core.dataresponse

class DataSuccess<T> (responseData: T?): DataResponse<T>(responseData, null)