package com.example.phone.usecase

import com.example.phone.model.ApiResponse
import com.example.phone.model.ApiResult
import com.example.phone.model.JsonSample
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImdbUseCase() {

    suspend fun getData(): ApiResponse {
        return withContext(Dispatchers.IO) {
            return@withContext ApiResponse.Success(
                Gson().fromJson(
                    JsonSample.json,
                    ApiResult::class.java
                )
            )
        }
    }
}