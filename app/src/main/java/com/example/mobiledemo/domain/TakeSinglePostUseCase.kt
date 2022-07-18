package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.ItemPost
import com.example.mobiledemo.data.model.response.ListPostResponse
import com.example.mobiledemo.data.model.response.SinglePostResponse

class TakeSinglePostUseCase {

    private val repositorio = AppRepository()

    suspend operator fun invoke(id:String): SinglePostResponse {
        return repositorio.getOnePost(id)
    }
}