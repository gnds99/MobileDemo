package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.HomeResponse

class TakeLastItemViewUseCase {
    private val repositorio = AppRepository()

    suspend operator fun invoke(): HomeResponse {
        return repositorio.getLastItemView()
    }
}