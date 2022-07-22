package com.example.mobiledemo.data.model.request

import com.google.gson.annotations.SerializedName

data class PhotoLocation (
    @SerializedName("latitude")  val latitude: Double,
    @SerializedName("longitude")  val longitude: Double) {
}