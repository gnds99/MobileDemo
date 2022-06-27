package com.example.mobiledemo.data

import com.example.mobiledemo.data.model.response.SmsResponse
import com.example.mobiledemo.data.model.response.UserResponse
import com.example.mobiledemo.data.network.ApiService

class AppRepository {

    private val api = ApiService()

    suspend fun getLogin(phone:String, password: String): UserResponse {
        val response = api.login(phone, password)
        return response
    }

    suspend fun getOtpVerification(): SmsResponse{
        val response = api.OtpVerification()
        return response
    }
}