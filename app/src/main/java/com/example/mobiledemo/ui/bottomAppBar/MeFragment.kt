package com.example.mobiledemo.ui.bottomAppBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.R
import com.example.mobiledemo.databinding.FragmentMeBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel


class MeFragment : Fragment() {

    private var _binding: FragmentMeBinding? = null
    private val binding get() = _binding!!
    private val sharedVieModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentMeBinding.inflate(inflater, container, false)

        // MOSTRANDO LA INFORMACION DEL USUARIO EN LA VISTA
        sharedVieModel.startGetMe()
        sharedVieModel.meInformation.observe(viewLifecycleOwner){
            binding.meEmail.setText(sharedVieModel.meInformation.value!!.user.email)
            binding.mePhone.setText(sharedVieModel.meInformation.value!!.user.phone)
        }

        return binding.root
    }

}