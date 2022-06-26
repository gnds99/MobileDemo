package com.example.mobiledemo.ui.bottomAppBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledemo.databinding.FragmentItemsBinding
import com.example.mobiledemo.ui.recycleView.Datasource
import com.example.mobiledemo.ui.recycleView.ItemCardAdapter


class ItemsFragment : Fragment() {

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        // CARGANDO DATOS
        val myDataset = Datasource().loadInformation()
        recyclerView = binding.recyclerView
        recyclerView.adapter = ItemCardAdapter(context, myDataset)
        recyclerView.setHasFixedSize(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}