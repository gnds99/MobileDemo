package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.SmsResponse


class OtpVerificationCase {
    private val repository = AppRepository()

    suspend operator fun invoke(): SmsResponse {
        return repository.getOtpVerification()
    }
}