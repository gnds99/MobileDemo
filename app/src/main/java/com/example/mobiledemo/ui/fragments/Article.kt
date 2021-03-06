package com.example.mobiledemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.databinding.FragmentArticleBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel


class Article(val id:String) : Fragment() {
    private val sharedVieModel: AppViewModel by activityViewModels()
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        sharedVieModel.starGetSinglePost(id)
        sharedVieModel.singlePostData.observe(viewLifecycleOwner){
            binding.articleTitle.text = sharedVieModel.singlePostData.value?.item?.title
            binding.articleDescription.text = sharedVieModel.singlePostData.value!!.item.longInfo
        }
        sharedVieModel.isLoading.observe(viewLifecycleOwner){
            binding.progress.isVisible = it
        }

        val bottomSheetFragment = GoogleMaps()
        binding.buttonejemplo.setOnClickListener {
            bottomSheetFragment.show(parentFragmentManager, "BottomSheetDialog")
        }

        return binding.root
    }


}