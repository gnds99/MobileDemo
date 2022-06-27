package com.example.mobiledemo.core

import com.example.mobiledemo.data.network.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    // Cliente
    val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()
    fun getRetrofi(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dev-training-api.inmediatum.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}