package com.example.mobiledemo.domain

import com.example.mobiledemo.data.AppRepository
import com.example.mobiledemo.data.model.response.UserResponse

// CASO DE USO PARA EL INICIO DE SESIÓN
class LoginUseCase {

    private val repository = AppRepository()

    // SOLICITANDO UN OBJETO CON LOS DATOS DE RESPUESTA DEL SERVIDOR
    suspend fun invoke(phone:String, password: String): UserResponse {
        val prueba = repository.getLogin(phone,password)
        println("Aqui adamos LoginUseCase: "+ prueba.sms)
        return repository.getLogin(phone,password)
    }

}