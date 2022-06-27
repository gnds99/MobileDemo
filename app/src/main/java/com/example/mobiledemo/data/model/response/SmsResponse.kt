package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class SmsResponse(
    @SerializedName("ok") val bandera: Boolean,
    @SerializedName("msg") val message: String,
    @SerializedName("token") val xToken: String)

