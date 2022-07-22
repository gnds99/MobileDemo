package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import okhttp3.MultipartBody
import okhttp3.ResponseBody

class UpdatePhotoUseCase {
    private val repositorio = AppRepository()

    suspend operator fun invoke(photo: MultipartBody.Part): ResponseBody {
        return repositorio.updatePhoto(photo)
    }
}