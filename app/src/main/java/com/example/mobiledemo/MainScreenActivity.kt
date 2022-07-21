package com.example.mobiledemo

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mobiledemo.core.Options
import com.example.mobiledemo.sharePreferences.UserApplication.Companion.prefs
import com.example.mobiledemo.ui.NewPostDialogFragment
import com.example.mobiledemo.ui.bottomAppBar.ConfigFragment
import com.example.mobiledemo.ui.bottomAppBar.HomeFragment
import com.example.mobiledemo.ui.bottomAppBar.ItemsFragment
import com.example.mobiledemo.ui.bottomAppBar.MeFragment
import com.example.mobiledemo.ui.viewModel.AppViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    // DRAWER NAVIGATION VARIABLES
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout
    private lateinit var floatActionButton: FloatingActionButton


    // BOTOM NAVIGATION VARIABLES
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        val screen = intent?.extras?.getInt("screen", 0)

        // DRAWER NAVIGATION CONFIGURACION
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // BOTOM NAVIGATION CONFIGURATION
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setBackgroundColor(Color.TRANSPARENT)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> replaceFragment(HomeFragment())
                R.id.miItems -> replaceFragment(ItemsFragment())
                R.id.miMe -> replaceFragment(MeFragment())
                R.id.miConfig -> replaceFragment(ConfigFragment())

            }
            return@setOnItemSelectedListener true
        }

        floatActionButton = findViewById(R.id.fab)
        floatActionButton.setOnClickListener {
            NewPostDialogFragment().show(supportFragmentManager, "dialog")
        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        initScreen(HomeFragment())

        println("x-token: " + prefs.getXToken())
        println("uui: "+ prefs.getToken())
    }

    // ESTOS METODOS SON PARA EL DRAWER NAVIGATION
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // AQUI SE CONFIGURTAN LOS FRAGMENTS DEL DRAWER
        when (item.itemId){
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_items -> replaceFragment(ItemsFragment())
            R.id.nav_me -> replaceFragment(MeFragment())
            R.id.nav_config -> replaceFragment(ConfigFragment())
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // ESTE METODO SIRVE PARA CAMBIAR LOS FRAGMENTOS
    fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contenedorFragment, fragment)
        fragmentTransaction.commit()
    }

    fun initScreen(fragment: Fragment){
        supportFragmentManager.beginTransaction() // configurando fragment principal
            .add(R.id.contenedorFragment, fragment) //contenedor y fragmento
            .commit() // iniciando
    }


}