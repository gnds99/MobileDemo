package com.example.mobiledemo.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobiledemo.MainScreenActivity
import com.example.mobiledemo.databinding.FragmentFingerPrintBinding


class FingerPrint : Fragment() {

    private var _binding: FragmentFingerPrintBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentFingerPrintBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNo.setOnClickListener {
           startActivity(Intent(context, MainScreenActivity::class.java))
        }
    }

}