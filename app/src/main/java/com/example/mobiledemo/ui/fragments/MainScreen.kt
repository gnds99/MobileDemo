package com.example.mobiledemo.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mobiledemo.R
import com.example.mobiledemo.databinding.FragmentMainScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainScreen : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    // DRAWER NAVIGATION VARIABLES
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout

    // BOTOM NAVIGATION VARIABLES
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
