package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class DataPostResponse(
    @SerializedName("ok") val bandera: Boolean,
    @SerializedName("msg") val mensaje: String)