package com.example.mobiledemo.data.model.response

import android.location.Location
import com.example.mobiledemo.data.model.request.PhotoLocation
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("title") val title:String,
    @SerializedName("info") val info:String,
    @SerializedName("photo") val photo:String,
    @SerializedName("location") val location: PhotoLocation
)