package com.example.phone.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiResult {
    @SerializedName("dates")
    @Expose
    val dates: Dates? = null

    @SerializedName("page")
    @Expose
    val page: Long? = null

    @SerializedName("results")
    @Expose
    val results: List<Result>? = null

    @SerializedName("total_pages")
    @Expose
    val totalPages: Long? = null

    @SerializedName("total_results")
    @Expose
    val totalResults: Long? = null

}