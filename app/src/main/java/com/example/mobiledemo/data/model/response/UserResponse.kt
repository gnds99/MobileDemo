package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("ok") var bandera: Boolean,
    @SerializedName("msg") var mensaje: String,
    @SerializedName("sms") var sms: String
)