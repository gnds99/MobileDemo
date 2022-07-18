package com.example.mobiledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mobiledemo.ui.bottomAppBar.HomeFragment
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.logging.Level

class MainActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }




}