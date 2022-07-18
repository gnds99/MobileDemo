package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.UserMeResponse

class TakeUserInformationUseCAse {
    private val repositorio = AppRepository()

    suspend operator fun invoke(): UserMeResponse {
        return repositorio.getUserInformation()
    }
}