package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class VerificationUserResponse(
    @SerializedName("ok") val bandera: Boolean,
    @SerializedName("msg") val mensaje: String)