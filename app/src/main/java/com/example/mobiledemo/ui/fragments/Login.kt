package com.example.mobiledemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mobiledemo.R
import com.example.mobiledemo.core.Options
import com.example.mobiledemo.databinding.FragmentLoginBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel
import kotlin.math.hypot


class Login : Fragment() {

    // ViewModel
    private val sharedVieModel: AppViewModel by activityViewModels()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // OBSERVAMOS QUE EXISTA UN CAMBIO DE ESTADO EN EL LOGIN
        sharedVieModel.login.observe(viewLifecycleOwner) {
            // VERIFICACAMOS SI EL CAMBIO FUE EXITOSO
            if (sharedVieModel.login.value == Options.YES) {
                this.goToNextScreen()
            }else if(sharedVieModel.login.value == Options.NO){
                // MOSTRAMOS UN MENSAJE SI NO ES POSIBLE INICIAR SESIÓN
                this.showMessage("El usuario no existe")
            }
        }
        // BOTOM PARA VALIDAR EL FORMULARIO
        binding.btnLogin.setOnClickListener {
            if(        this.dataVerification())
                sharedVieModel.StartLogin(binding.userEmail.editText?.text.toString(), binding.userPassword.editText?.text.toString())
            else{
                this.showMessage("Debes llenar todos los campos")
            }
        }
    }

    private fun goToNextScreen()
    {
        // CREAMOS LA ACCION DE NAVEGACIÓN Y PASAMOS EL PARAMETRO
        val action = LoginDirections.actionLoginToConfirmation()
        // NAVEGAMOS AL SIGUIENTE FRAGMENTO
        findNavController().navigate(action)
    }

    private fun showMessage(mensaje: String)
    {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun dataVerification(): Boolean
    {
        if(binding.userEmail.editText?.text.toString().isEmpty())
        {
            binding.userEmail.error = getString(R.string.emailError)
            return false
        }else{
            binding.userEmail.error = null
        }
        if(binding.userPassword.editText?.text.toString().isEmpty())
        {
            binding.userPassword.error = getString(R.string.passwordError)
            return false
        }else{
            binding.userPassword.error = null
        }
        return true
    }

}