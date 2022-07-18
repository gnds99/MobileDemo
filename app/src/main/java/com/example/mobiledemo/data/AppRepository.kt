package com.example.mobiledemo.data

import com.example.mobiledemo.data.model.request.PostRequest
import com.example.mobiledemo.data.model.response.*
import com.example.mobiledemo.data.network.ApiService
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs

class AppRepository {

    private val api = ApiService()

    // CONSULTAR AL SEVIDOR PARA EL INICIO DE SESIÓN
    suspend fun getLogin(phone:String, password: String): UserResponse {
        val response = api.login(phone, password)
        println("Aqui andamos AppRepositori: " + response.sms)
        return response
    }


    // CONSULTA AL SERVIDOR PARA VERIFICAR EL OTP
    suspend fun getOtpVerification(numberChain:String): SmsResponse{
        val response = api.OtpVerification(numberChain)
        return response
    }

    // CONSULTA AL SERVIDOR PARA CREAR UN POST
    suspend fun getNewPost(post: PostRequest): PostResponse{
        //println("ESTE ES EL TOKEM DE DISPOSITIVO" + prefs.getToken())
        //println("ESE ES EL X-TOKEN"+prefs.getToken())
        //println()
        val response = api.createNewPost(post)
        return response
    }

    // SOLICTUD AL SERVIDOR PARA OBTENER LA LISTA DE PUBLICACIONES
    suspend fun getAllData(): ListPostResponse{
        val response = api.takeData()
        return response
    }

    // SOLICITUD AL SERVIDOR PARA OBTENER LA INFORMACION DE UNA PUBLICACION
    suspend fun getOnePost(id: String): SinglePostResponse{
        val response = api.takePost(id)
        return response
    }

    // SOLICITANDO AL SERVIDOR OBTENER LA INFORMACION DEL USUARIO
    suspend fun getUserInformation(): UserMeResponse{
        val response = api.takeUserInformation()
        return response
    }

    suspend fun getLastItemView(): HomeResponse{
        val response = api.takeLastItemView()
        return response
    }
}