package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class SmsResponse(@SerializedName("ok") val bandera: Boolean,
                  @SerializedName("message") val message: String)
