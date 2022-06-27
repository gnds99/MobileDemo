package com.example.mobiledemo.data.model.request

import com.google.gson.annotations.SerializedName

data class SmsRequest(@SerializedName("sms") val sms:String)