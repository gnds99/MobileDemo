package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.request.PostRequest
import com.example.mobiledemo.data.model.response.PostResponse

class NewPostUseCase {
    private val repository = AppRepository()

    suspend fun invoke(post: PostRequest): PostResponse {
        val prueba = repository.getNewPost(post)
        println("SOLICITAMOS LA CREACION DE NUEVO POST")
        return prueba
    }
}