package com.example.mobiledemo.sharePreferences

import android.content.Context
import dagger.hilt.android.HiltAndroidApp


class Prefs (private val context: Context){
    private val SHARED_NAME = "MyDataBase"
    private val SHARED_PHONE = ""
    private val DEVICE_TOKEN = ""
    private val storage = context.getSharedPreferences(SHARED_NAME, 0)

    // METODO PARA GUARDAR EL CORREO DEL USUAIRO
    fun saveToken(token:String)
    {
        storage.edit().putString(DEVICE_TOKEN, token).apply()
    }

    // METODO PARA RETORNAR EL CORREO DEL USUARIO
    fun getToken(): String{

        return storage.getString(DEVICE_TOKEN, "")!!
    }

    // METODO PARA GUARDAR EL NUMERO DEL USUAIRO
    fun savePhone(phone: String)
    {
        storage.edit().putString(SHARED_PHONE, phone).apply()
    }

    // METODO PARA RETORNAR EL CORREO DEL USUARIO
    fun getPhone(): String{
        return storage.getString(SHARED_PHONE, "")!!
    }

    // METODO PARA ELIMINAR TODOS LOS DATOS ALMANCENADOS
    fun wipe(){
        storage.edit().clear().apply()
    }
}
