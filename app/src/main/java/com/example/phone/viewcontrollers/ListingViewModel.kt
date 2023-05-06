package com.example.phone.viewcontrollers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phone.model.ApiResponse
import com.example.phone.model.ApiResult
import com.example.phone.model.JsonSample
import com.example.phone.usecase.ImdbUseCase
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListingViewModel() : ViewModel(), CoroutineScope {
    private val moviesList = MutableLiveData<List<com.example.phone.model.Result>>()
    val movies: LiveData<List<com.example.phone.model.Result>> = moviesList

//    Ideally this should be injected. But due to lack of time couldnt create components and injector
    val useCase: ImdbUseCase = ImdbUseCase()


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    fun getListOfMovies() {
        launch {
            val result: Deferred<ApiResponse> = async {
                return@async useCase.getData()
            }
            val response = result.await()
            if (response is ApiResponse.Success) {
                if (response.apiResult.results?.isNotEmpty() == true)
                    moviesList.value = response.apiResult.results
            } else if (response is ApiResponse.Fail) {
//                Could do better error handling here
                moviesList.value = listOf()
            }
        }
    }
}