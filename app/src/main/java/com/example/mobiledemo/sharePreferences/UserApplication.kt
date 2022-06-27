package com.example.mobiledemo.sharePreferences

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import java.util.*


class UserApplication: Application() {

    // CONSTANTE QUE CONTIENE LA INSTANCIA QUE ALMACENA TODOS LOS VALORES DE LA APLICACION
    companion object{
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext) // MANDAMOS EL CONTEXTO

        if(prefs.getToken().isEmpty())
            prefs.saveToken(UUID.randomUUID().toString())


    }
}