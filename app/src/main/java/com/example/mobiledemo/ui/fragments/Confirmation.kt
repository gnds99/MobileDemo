package com.example.mobiledemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mobiledemo.databinding.FragmentConfirmationBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel


class Confirmation : Fragment() {
    // ViewModel
    private val sharedVieModel: AppViewModel by activityViewModels()

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentConfirmationBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedVieModel.otp.observe(viewLifecycleOwner){
            showMessage(sharedVieModel.otp.value.toString())
        }

        binding.btnSend.setOnClickListener {

        }
    }

    private fun dataVerification(): Boolean{
        val numberChain = binding.txtOne.editText?.text.toString() +
                binding.txtTwo.editText?.text.toString() +
                binding.txtThree.editText?.text.toString() +
                binding.txtFour.editText?.text.toString()
        if(numberChain.isNotEmpty() && numberChain.length == 4)
            return true
        return false
    }

    private fun OtpVerification()
    {

    }





    private fun goToNextScreen()
    {
        val action = ConfirmationDirections.actionConfirmationToFingerPrint()
        findNavController().navigate(action)
    }

    private fun showMessage(mensaje: String)
    {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

}