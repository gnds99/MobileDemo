package com.example.mobiledemo.data.model.request

import com.google.gson.annotations.SerializedName

data class UserLoginRequest(
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String)