package com.example.mobiledemo.ui.bottomAppBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledemo.databinding.FragmentItemsBinding
import com.example.mobiledemo.ui.recycleView.ItemCardAdapter
import com.example.mobiledemo.ui.viewModel.AppViewModel


class ItemsFragment : Fragment() {

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val sharedVieModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        // CARGANDO DATOS


        sharedVieModel.StartAllPost()
        sharedVieModel.posData.observe(viewLifecycleOwner){
            //val myDataset = Datasource().loadInformation()
            val myDataset = sharedVieModel.posData.value?.item
            recyclerView = binding.recyclerView
            recyclerView.adapter = ItemCardAdapter(context, myDataset!!)
            recyclerView.setHasFixedSize(true)
        }
        sharedVieModel.isLoading.observe(viewLifecycleOwner){
            binding.progress.isVisible = it
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}