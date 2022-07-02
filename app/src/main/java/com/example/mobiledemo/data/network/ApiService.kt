package com.example.mobiledemo.data.network

import Wrapper
import com.example.mobiledemo.core.RetrofitHelper
import com.example.mobiledemo.data.model.request.PhotoLocation
import com.example.mobiledemo.data.model.request.PostRequest
import com.example.mobiledemo.data.model.request.SmsRequest
import com.example.mobiledemo.data.model.request.UserLoginRequest
import com.example.mobiledemo.data.model.response.PostResponse
import com.example.mobiledemo.data.model.response.SmsResponse
import com.example.mobiledemo.data.model.response.UserResponse
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofi()

    // SOLICITUD AL SERVIDOR PARA EL LOGIN
    suspend fun login(phone:String, password: String): UserResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).userLoginApi(Wrapper(UserLoginRequest(phone, password)))
            Gson().fromJson(response.body()!!.asJsonObject,UserResponse::class.java)
        }
    }

    // SOLICITUD AL SERVIDOR PARA VALIDAR EL OTP
    suspend fun OtpVerification(numberChain:String): SmsResponse{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).otpVerificationApi(prefs.getPhone(), SmsRequest(numberChain))
            response.body() ?: SmsResponse(false, "OTP incorrecto", "")
        }
    }

    // SOLICITANDO AL SERVIDOR CREAR UNA NUEVA PUBLICACIÓN
    suspend fun createNewPost(post: PostRequest): PostResponse{
        return withContext(Dispatchers.IO){
            println(prefs.getXToken())
            println(prefs.getToken())
            val response = retrofit.create(ApiClient::class.java).createPost(post)
            if(response.isSuccessful)
            {
                println("Entramos")
            }else{
                println("Error")
            }
            PostResponse("Entre", "No info", "No photo", PhotoLocation(0.0, 0.0))

            //response.body() ?: PostResponse("Entre", "No info", "No photo", PhotoLocation(0.0f, 0.0f))
        }
    }

}