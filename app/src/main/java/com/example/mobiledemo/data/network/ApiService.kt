package com.example.mobiledemo.data.network

import Wrapper
import com.example.mobiledemo.core.RetrofitHelper
import com.example.mobiledemo.data.model.request.SmsRequest
import com.example.mobiledemo.data.model.request.UserLoginRequest
import com.example.mobiledemo.data.model.response.SmsResponse
import com.example.mobiledemo.data.model.response.UserResponse
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofi()

    // SOLICITUD AL SERVIDOR PARA EL LOGIN
    suspend fun login(phone:String, password: String): UserResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).userLoginApi(Wrapper(UserLoginRequest(phone, password)))
            response.body() ?: UserResponse(false, "Phone or password not valid","xxxx")
        }
    }

    // SOLICITUD AL SERVIDOR PARA VALIDAR EL OTP
    suspend fun OtpVerification(numberChain:String): SmsResponse{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).otpVerificationApi(prefs.getPhone(), SmsRequest(numberChain))
            response.body() ?: SmsResponse(false, "OTP incorrecto", "")
        }
    }


}