package com.example.mobiledemo.ui.bottomAppBar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.MainArticleActivity
import com.example.mobiledemo.R
import com.example.mobiledemo.databinding.FragmentHomeBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val sharedVieModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // AQUI CONFIGURAMOS LA VISTA
        sharedVieModel.startLastItemView()
        sharedVieModel.lastPost.observe(viewLifecycleOwner){
            binding.txtWelcome.setText("Hi, " + sharedVieModel.lastPost.value!!.userData.userName)
            val item = sharedVieModel.lastPost.value!!.userData.items.lastOrNull()
            binding.txtTitleCard.setText(item!!.title)
            binding.txtDescriptionCard.setText(item!!.info)

            binding.btnDetials.setOnClickListener {
                val intent = Intent(context, MainArticleActivity::class.java)
                intent.putExtra("id",item.id)
                context?.startActivity(intent)
            }
        }
        sharedVieModel.isLoading.observe(viewLifecycleOwner){
            binding.progress.isVisible = it
        }

        return binding.root
    }

}