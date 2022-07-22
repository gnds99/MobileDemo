package com.example.mobiledemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.R
import com.example.mobiledemo.databinding.FragmentGoogleMapsBinding
import com.example.mobiledemo.ui.viewModel.AppViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class GoogleMaps : BottomSheetDialogFragment(), OnMapReadyCallback {

    private var _binding: FragmentGoogleMapsBinding? = null
    private val binding get() = _binding!!
    private lateinit var map: GoogleMap
    private var mapFragment: SupportMapFragment? = null
    private lateinit var marker: MarkerOptions
    private val sharedVieModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentGoogleMapsBinding.inflate(inflater, container, false)
        val latitude = sharedVieModel.singlePostData.value!!.item.location.latitude
        val longitude = sharedVieModel.singlePostData.value!!.item.location.longitude
        val title = sharedVieModel.singlePostData.value!!.item.title
        mapFragment = SupportMapFragment.newInstance()
        mapFragment!!.getMapAsync(OnMapReadyCallback { googleMap ->
            val coordinates = LatLng(latitude,longitude)
            marker =  MarkerOptions().position(coordinates)
                    .title(title)
            googleMap.addMarker(marker)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 18f), 4000, null)
        })


        childFragmentManager.beginTransaction().replace(R.id.map, mapFragment!!).commit()
        return binding.root
    }

    private fun createFragment(){

        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker()
    {
        val coordinates = LatLng(21.096427,-86.853009)
        val marker = MarkerOptions().position(coordinates).title("Berserker")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
        Toast.makeText(context,"Entre con exito", Toast.LENGTH_SHORT).show()
    }


}