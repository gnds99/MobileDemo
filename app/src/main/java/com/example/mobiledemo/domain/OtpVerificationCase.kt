package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.SmsResponse


// CASO DE USO PARA LA VERIFICACION DEL OTP
class OtpVerificationCase {
    private val repository = AppRepository()

    suspend operator fun invoke(numberChain:String): SmsResponse {
        return repository.getOtpVerification(numberChain)
    }
}