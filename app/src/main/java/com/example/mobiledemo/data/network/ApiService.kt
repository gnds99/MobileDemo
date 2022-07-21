package com.example.mobiledemo.data.network

import Wrapper
import com.example.mobiledemo.core.RetrofitHelper
import com.example.mobiledemo.data.model.request.*
import com.example.mobiledemo.data.model.response.*
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofi()

    // SOLICITUD AL SERVIDOR PARA EL LOGIN
    suspend fun login(phone:String, password: String): UserResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).userLoginApi(Wrapper(UserLoginRequest(phone, password)))
            Gson().fromJson(response.body()!!.asJsonObject,UserResponse::class.java)
        }
    }

    // SOLICITUD AL SERVIDOR PARA VALIDAR EL OTP
    suspend fun OtpVerification(numberChain:String): SmsResponse{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).otpVerificationApi(prefs.getPhone(), SmsRequest(numberChain))
            response.body() ?: SmsResponse(false, "OTP incorrecto", "")
        }
    }

    // SOLICITANDO AL SERVIDOR CREAR UNA NUEVA PUBLICACIÓN
    suspend fun createNewPost(post: PostRequest): PostResponse{
        return withContext(Dispatchers.IO){
            //println(prefs.getXToken())
            //println(prefs.getToken())
            val response = retrofit.create(ApiClient::class.java).createPost(post)
          /* if(response.isSuccessful)
            {
                println("Entramos")
            }else{
                println("Error")
            }*/
            //PostResponse("Entre", "No info", "No photo", PhotoLocation(0.0, 0.0))

            response.body() ?: PostResponse("Entre", "No info", "No photo", PhotoLocation(0.0, 0.0))
        }
    }

    // FUNCION QUE OBTIENE TODAS LA PUBLICACIONES DEL SERVIDOR
    suspend fun takeData(): ListPostResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).allData()
            response.body() ?: ListPostResponse(false,"", emptyList())
        }
    }

    // FUNCION QUE TOMA UNA SOLA PUBLICACION
    suspend fun takePost(id:String ): SinglePostResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).getItem(id)
            response.body() ?: SinglePostResponse(false,ItemPost("","","",PhotoLocation(0.0,0.0),"","","",""))
        }
    }

    // FUNCION QUE SOLICITA LA INFORMACION DEL USUARIO AL SERVIDOR
    suspend fun takeUserInformation(): UserMeResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).getUserMe()
            response.body() ?: UserMeResponse(false,"", UserRequest("","",""))
        }
    }

    //FUNCION QUE OBTIENE DEL SERVIDOR LA ULTIMA PUBLICACION REVISADA POR EL USUARIO
    suspend fun takeLastItemView(): HomeResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiClient::class.java).getHome()
            response.body() ?: HomeResponse(false, "", UserDataResponse("","", emptyList()))
        }
    }

}