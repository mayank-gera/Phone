package com.example.phone.model

sealed class ApiResponse {
    class Success(val apiResult: ApiResult) : ApiResponse()
    class Fail(throwable: Throwable) : ApiResponse()
}