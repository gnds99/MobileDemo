package com.example.mobiledemo.data.model.response

import com.example.mobiledemo.data.model.request.UserRequest
import com.google.gson.annotations.SerializedName

data class UserMeResponse(
    @SerializedName("ok") val bandera: Boolean,
    @SerializedName("msg") val mensaje: String,
    @SerializedName("userMe") val user: UserRequest
)