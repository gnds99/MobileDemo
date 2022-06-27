package com.example.mobiledemo.data

import com.example.mobiledemo.data.model.response.SmsResponse
import com.example.mobiledemo.data.model.response.UserResponse
import com.example.mobiledemo.data.network.ApiService

class AppRepository {

    private val api = ApiService()

    // CONSULTAR AL SEVIDOR PARA EL INICIO DE SESIÓN
    suspend fun getLogin(phone:String, password: String): UserResponse {
        val response = api.login(phone, password)
        println("Aqui andamos AppRepositori: " + response.sms)
        return response
    }


    // CONSULTA AL SERVIDOR PARA VERIFICAR EL OTP
    suspend fun getOtpVerification(numberChain:String): SmsResponse{
        val response = api.OtpVerification(numberChain)
        return response
    }
}