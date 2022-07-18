package com.example.mobiledemo.data.model.request

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String)