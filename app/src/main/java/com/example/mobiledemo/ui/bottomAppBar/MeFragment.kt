package com.example.mobiledemo.ui.bottomAppBar

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.databinding.FragmentMeBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel
import okhttp3.MediaType
import okhttp3.RequestBody


class MeFragment : Fragment() {

    private var _binding: FragmentMeBinding? = null
    private val binding get() = _binding!!
    private val sharedVieModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
       _binding = FragmentMeBinding.inflate(inflater, container, false)

        // MOSTRANDO LA INFORMACION DEL USUARIO EN LA VISTA
        sharedVieModel.startGetMe()
        sharedVieModel.meInformation.observe(viewLifecycleOwner){
            binding.meEmail.setText(sharedVieModel.meInformation.value!!.user.email)
            binding.mePhone.setText(sharedVieModel.meInformation.value!!.user.phone)
        }

         binding.change.setOnClickListener {
             requesPermission()
         }
        return binding.root
    }

    private fun requesPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ){
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) -> {
                    pickPhotoFromGallery()
                }
                else -> requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }else{
            pickPhotoFromGallery()
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        isGranted ->
        if(isGranted){
            pickPhotoFromGallery()
        }else{
            Toast.makeText(context, "Necesitas habilitar los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    private val startForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result->
        if(result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data

            //sharedVieModel.startUpdatePhoto()
            binding.imageView3.setImageURI(data)
        }
    }
    private fun pickPhotoFromGallery(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)


    }



}