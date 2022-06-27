package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.UserResponse

class LoginUseCase {

    private val repository = AppRepository()

    suspend operator fun invoke(phone:String, password: String): UserResponse {
        return repository.getLogin(phone,password)
    }

}