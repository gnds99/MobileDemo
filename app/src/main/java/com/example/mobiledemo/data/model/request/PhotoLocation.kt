package com.example.mobiledemo.data.model.request

import com.google.gson.annotations.SerializedName

data class PhotoLocation (
    @SerializedName("latitude") private val latitude: Double,
    @SerializedName("longitude") private val longitude: Double) {
}