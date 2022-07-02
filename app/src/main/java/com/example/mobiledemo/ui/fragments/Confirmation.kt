package com.example.mobiledemo.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mobiledemo.MainScreenActivity
import com.example.mobiledemo.core.Options
import com.example.mobiledemo.databinding.FragmentConfirmationBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel


class Confirmation : Fragment() {
    // ViewModel
    private val sharedVieModel: AppViewModel by activityViewModels()

    // Cadena otp
    lateinit var numberChain: String

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // VERIFICAMOS EL CAMBIO DE DATO EN EL VIEWMODEL
        sharedVieModel.otp.observe(viewLifecycleOwner) {
            showMessage(sharedVieModel.otp.value.toString()) // MOSTRAMOS EN PANTALLA EL CODIGO
        }

        // VERIFICAMOS EL CAMBIO DE DATO EN EL VIEWMODEL
        sharedVieModel.verificactionOtp.observe(viewLifecycleOwner) {
            // VERIFICACAMOS SI EL CAMBIO FUE EXITOSO
            if (sharedVieModel.verificactionOtp.value == Options.YES) {
                println("Estoy diciendo que yes")
                this.goToHome() // NOS MOVEMOS A LA SIGUIENTE PANTALLA
            } else if (sharedVieModel.verificactionOtp.value == Options.NO) {
                println("Estoy diciendo que NO")
                // MOSTRAMOS UN MENSAJE SI AUN NO SE REALIZA EL CAMBIO
                this.showMessage("El codigo es incorrecto")
            }
        }

        // BOTON QUE REALIZA UNA ACCION
        binding.btnSend.setOnClickListener {
            // VERIFICAMOS QUE EXISTAN DATOS
            if (dataVerification()) {
                sharedVieModel.StarVerificationOtp(numberChain) // VERIFICAMOS EL OTP
            } else {
                // MOSTRAMOS MENSAJE SI NO EXISTEN DATOS
                showMessage("El codigo es incorrecto")
            }

        }
    }

    // METODO QUE VERIFICA QUE EXISTAN DATOS EN LOS CAMPOS
    private fun dataVerification(): Boolean {
        numberChain = binding.txtOne.editText?.text.toString() +
                binding.txtTwo.editText?.text.toString() +
                binding.txtThree.editText?.text.toString() +
                binding.txtFour.editText?.text.toString()
        if (numberChain.isNotEmpty() && numberChain.length == 4)
            return true
        return false
    }


    // METODO QUE MUESTRA UN MENSAJE
    private fun showMessage(mensaje: String)
    {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun goToHome(){
        startActivity(Intent(context, MainScreenActivity::class.java))
    }
}