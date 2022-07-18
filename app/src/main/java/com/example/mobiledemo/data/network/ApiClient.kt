package com.example.mobiledemo.data.network

import Wrapper
import com.example.mobiledemo.data.model.request.PostRequest
import com.example.mobiledemo.data.model.request.SmsRequest
import com.example.mobiledemo.data.model.request.UserRequest
import com.example.mobiledemo.data.model.response.*
import com.google.gson.JsonElement
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {


    @POST("/auth/login")
    //suspend fun userLoginApi(@Body wrapper: Wrapper): Response<UserResponse>
    suspend fun userLoginApi(@Body wrapper: Wrapper): Response<JsonElement>

    @POST("/auth/otp/{phone}")
    suspend fun otpVerificationApi(@Path("phone") phone: String, @Body smsInformation: SmsRequest): Response<SmsResponse>

    @POST("/items/")
    suspend fun createPost(@Body post: PostRequest): Response<PostResponse>

    @GET("items?search=")
    suspend fun allData(): Response<ListPostResponse>

    @GET("/items/{id}")
    suspend fun getItem(@Path("id") id:String): Response<SinglePostResponse>

    @GET("/auth/me")
    suspend fun getUserMe(): Response<UserMeResponse>

    @GET("/home")
    suspend fun getHome(): Response<HomeResponse>



//    @POST("/user/create-user")
  //  suspend fun createUser(@Body User: UserRequest): Response<VerificationUserResponse>

   // @GET("/auth/sms-verification")
    //suspend fun userLogin(): Response<SmsResponse>

}