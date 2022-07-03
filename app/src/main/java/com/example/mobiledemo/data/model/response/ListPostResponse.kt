package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class ListPostResponse(
    @SerializedName("ok") val bandera: Boolean,
    @SerializedName("msg") val mensaje: String,
    @SerializedName("items") val item: List<ItemPost>)