package com.example.mobiledemo.data.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("ok") var bandera: Boolean,
    @SerializedName("msg") var mensaje: String,
    @SerializedName("sms") var sms: String?,
    @SerializedName("username") var username:String?,
    @SerializedName("email") var email:String?,
    @SerializedName("phone") var phone:String?,
    @SerializedName("token") var token: String?)