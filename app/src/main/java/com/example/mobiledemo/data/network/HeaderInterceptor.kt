package com.example.mobiledemo.data.network

import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("api-key", "a2216bda42cb4ff580bc5f49c8c1b9c1")
            .addHeader("plataform", "android")
            .addHeader("device-token", prefs.getToken())
            .addHeader("x-token", prefs.getXToken())
            .build()
        return chain.proceed(request)
    }
}