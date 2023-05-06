package com.example.phone.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Dates {
    @SerializedName("maximum")
    @Expose
    private val maximum: String? = null

    @SerializedName("minimum")
    @Expose
    private val minimum: String? = null
}