package com.example.mobiledemo.core

import com.example.mobiledemo.data.network.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level





object RetrofitHelper {

    // Cliente

    val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    fun getRetrofi(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dev-training-api.inmediatum.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}