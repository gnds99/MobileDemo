package com.example.mobiledemo.data.model.response

import android.service.autofill.UserData
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("ok") val bandera: Boolean,
    @SerializedName("msg") val mensaje: String,
    @SerializedName("userData") val userData: UserDataResponse
)