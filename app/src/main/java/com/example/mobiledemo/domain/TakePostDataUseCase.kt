package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.ListPostResponse

class TakePostDataUseCase {

    private val repositorio = AppRepository()

    suspend operator fun invoke(): ListPostResponse{
        return repositorio.getAllData()
    }
}