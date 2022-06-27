package com.example.mobiledemo.ui.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledemo.core.Options
import com.example.mobiledemo.domain.LoginUseCase
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import kotlinx.coroutines.launch


class AppViewModel: ViewModel() {

    // CASO DE USO PARA REALIZAR LOGIN
    private var loginUseCase = LoginUseCase()

    // VERIFICACIÓN DEL LOGIN
    private val _login = MutableLiveData<Options>(Options.FIRST)
    val login: LiveData<Options> = _login

    // OTP
    private val _otp = MutableLiveData<String>("")
    val otp: LiveData<String> = _otp


    // METODO PARA SOLICITAR INICIO DE SESIÓN
    fun StartLogin(phone:String, password: String){
        viewModelScope.launch {
            if(loginUseCase(phone, password).bandera)
            {
                prefs.savePhone(phone)
                setLogin(Options.YES) // INDICAMOS QUE FUE POSIBLE INICIAR SESIÓN
                setOtp(loginUseCase(phone, password).sms) // ALMACENAMOS EL OTP
            }
            else{
                setLogin(Options.NO) // INDICAMOS QUE NO FUE POSIBLE VERIFICAR EL INICIO DE SESIÓN
            }
        }
    }

    // METODO PARA CONFIGURAR EL ESTADO DEL LOGIN
    private fun setLogin(bandera: Options)
    {
        _login.value = bandera
    }

    // METODO PARA CONFIGURAR EL OTP
    private fun setOtp(otp: String){
        _otp.value = otp
    }

}