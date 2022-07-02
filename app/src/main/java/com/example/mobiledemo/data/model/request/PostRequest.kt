package com.example.mobiledemo.data.model.request
import com.google.gson.annotations.SerializedName

data class PostRequest(
    @SerializedName("title")  val title: String,
    @SerializedName("info")  val info: String,
    @SerializedName("phoneNumber")  val phoneNumber: String,
    @SerializedName("readingTime")  val readingTime: String,
    @SerializedName("longInfo")  val longInfo: String,
    @SerializedName("location")  val location: PhotoLocation)


//    @SerializedName("photo") private val photo: String,