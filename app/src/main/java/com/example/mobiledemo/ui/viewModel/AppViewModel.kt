package com.example.mobiledemo.ui.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledemo.core.Options
import com.example.mobiledemo.core.RetrofitHelper
import com.example.mobiledemo.data.model.request.PhotoLocation
import com.example.mobiledemo.data.model.request.PostRequest
import com.example.mobiledemo.domain.LoginUseCase
import com.example.mobiledemo.domain.NewPostUseCase
import com.example.mobiledemo.domain.OtpVerificationCase
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import kotlinx.coroutines.launch
import retrofit2.http.OPTIONS


class AppViewModel: ViewModel() {

    // CASO DE USO PARA REALIZAR LOGIN
    private var loginUseCase = LoginUseCase()
    // CASO DE USO PARA VERIFICAR EL OTP
    private var otpVerificationCase = OtpVerificationCase()

    private var newPostUseCase = NewPostUseCase()

    // STATUS DEL LOGIN
    private val _login = MutableLiveData<Options>(Options.FIRST)
    val login: LiveData<Options> = _login

    // STATUS DEL OTP
    private val _verificactionOtp = MutableLiveData<Options>(Options.FIRST)
    val verificactionOtp: LiveData<Options> = _verificactionOtp

    // VALOR DEL OTP
    private val _otp = MutableLiveData("") // ESTE DATO ES TEMPORAL
    val otp: LiveData<String> = _otp // ESTE DATO ES TEMPORAL

    // STATUS POST
    private val _post = MutableLiveData<Options>(Options.NO_POSTED)
    val post: LiveData<Options> = _post

    var ejemplo = false
    // ######## LLAMADAS AL SERVIDOR ########

    // METODO PARA SOLICITAR INICIO DE SESIÓN
    fun StartLogin(phone:String, password: String){
        viewModelScope.launch {
            val call = loginUseCase.invoke(phone, password)
            if(call.bandera)
            {
                prefs.savePhone(phone)
                prefs.saveXToken(call.token.toString())
                if(call.sms!=null)
                {
                    setLogin(Options.YES) // INDICAMOS QUE FUE POSIBLE INICIAR SESIÓN
                    println("OTP: " + call.sms)
                    println("Mensaje: " + call.mensaje)
                    println("Bandera: " + call.bandera)
                    println("UUI: " + prefs.getToken())
                    setOtp(call.sms!!) // ALMACENAMOS EL OTP
                }else {
                    setLogin(Options.HOME) // INDICAMOS QUE FUE POSIBLE INICIAR SESIÓN
                    println("ENTRAMOS A HOME")
                }
            }
            else{
                setLogin(Options.NO) // INDICAMOS QUE NO FUE POSIBLE VERIFICAR EL INICIO DE SESIÓN
            }
        }
    }

    // METODO PARA CONFIRMAR EL OTP INGRESADO POR EL USUARIO
    fun StarVerificationOtp(numberChain:String){
        viewModelScope.launch {
            //VERIFICAMOS SI EL OTP ES CORRECTO
            if(otpVerificationCase(numberChain).bandera)
            {
                // GUARDAMOS EL X-TOKEN EN SHARED PREFERENCES
                prefs.saveXToken(otpVerificationCase(numberChain).xToken)
                println("X-TOKEN: "+ otpVerificationCase(numberChain).xToken)
                println("Mensaje: " + otpVerificationCase(numberChain).message)
                setOtpVerificaction(Options.YES) // INDICAMOS QUE FUE POSIBLE INICIAR SESIÓN
            }else{
                setOtpVerificaction(Options.NO) // INDICAMOS QUE NO FUE POSIBLE VERIFICAR EL INICIO DE SESIÓN
            }
        }
    }

    fun StarNewPost(title:String, info:String){
        viewModelScope.launch {


            val post = PostRequest(title,info, prefs.getPhone(), "3min", "Long info", PhotoLocation(20.6720375,-103.338396))
            val call = newPostUseCase.invoke(post)
            if(call.title.isNotEmpty())
            {
                setPost(Options.POSTED)
            }else{
                setPost(Options.NO_POSTED)
            }
            println("AQUI ESTA EL TITUTLO" + call.title)
        }
    }


    // ######## SETTERS ########
    // METODO PARA CONFIGURAR EL ESTADO DEL LOGIN
    private fun setLogin(bandera: Options)
    {
        _login.value = bandera
    }
    // METODO PARA CONFIGURAR EL ESTADO DEl OTP VERIFICACION
    private fun setOtpVerificaction(bandera: Options)
    {
        _verificactionOtp.value = bandera
    }

    private fun setPost(bandera: Options)
    {
        _post.value = bandera
    }
    // METODO PARA CONFIGURAR EL OTP
    private fun setOtp(otp: String){
        _otp.value = otp
    }

}