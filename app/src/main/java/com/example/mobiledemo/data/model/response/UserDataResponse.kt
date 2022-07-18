package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("userName") val userName: String,
    @SerializedName("email") val email: String,
    @SerializedName("items") val items: List<ItemPost>
)