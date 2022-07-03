package com.example.mobiledemo.data.model.response

import com.example.mobiledemo.data.model.request.PhotoLocation
import com.google.gson.annotations.SerializedName

data class ItemPost(
    @SerializedName("_id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("info") val info: String,
    @SerializedName("location") val location: PhotoLocation)