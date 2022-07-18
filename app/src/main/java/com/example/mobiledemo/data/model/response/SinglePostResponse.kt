package com.example.mobiledemo.data.model.response

import com.example.mobiledemo.data.model.request.PhotoLocation
import com.google.gson.annotations.SerializedName

data class SinglePostResponse(
    @SerializedName("item") val item: ItemPost
)