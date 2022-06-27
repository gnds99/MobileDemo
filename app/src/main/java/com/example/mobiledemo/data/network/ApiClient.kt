package com.example.mobiledemo.data.network

import Wrapper
import com.example.mobiledemo.data.model.request.SmsRequest
import com.example.mobiledemo.data.model.request.UserRequest
import com.example.mobiledemo.data.model.response.SmsResponse
import com.example.mobiledemo.data.model.response.UserResponse
import com.example.mobiledemo.data.model.response.VerificationUserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {
    @POST("/auth/login")
    suspend fun userLoginApi(@Body wrapper: Wrapper): Response<UserResponse>

    @POST("/auth/otp/{phone}")
    suspend fun otpVerificationApi(@Path("phone") phone: String, @Body smsInformation: SmsRequest): Response<SmsResponse>

    @POST("/user/create-user")
    suspend fun createUser(@Body User: UserRequest): Response<VerificationUserResponse>

   // @GET("/auth/sms-verification")
    //suspend fun userLogin(): Response<SmsResponse>

}