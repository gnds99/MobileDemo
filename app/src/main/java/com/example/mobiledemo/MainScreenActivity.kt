package com.example.mobiledemo

import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mobiledemo.ui.bottomAppBar.ConfigFragment
import com.example.mobiledemo.ui.bottomAppBar.HomeFragment
import com.example.mobiledemo.ui.bottomAppBar.ItemsFragment
import com.example.mobiledemo.ui.bottomAppBar.MeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainScreenActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    // DRAWER NAVIGATION VARIABLES
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout

    // BOTOM NAVIGATION VARIABLES
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
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

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // CONFIGURANDO UNA PANTALLA PRINCIPAL
        supportFragmentManager.beginTransaction() // configurando fragment principal
            .add(R.id.contenedorFragment, HomeFragment()) //contenedor y fragmento
            .commit() // iniciando


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow, menu)
        return super.onCreateOptionsMenu(menu)
    }

}