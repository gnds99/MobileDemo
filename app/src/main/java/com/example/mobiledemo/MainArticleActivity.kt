package com.example.mobiledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobiledemo.ui.bottomAppBar.HomeFragment
import com.example.mobiledemo.ui.fragments.Article

class MainArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_article)

        val id = intent?.extras?.getString("id","0")

        // CONFIGURANDO UNA PANTALLA PRINCIPAL
        supportFragmentManager.beginTransaction() // configurando fragment principal
            .add(R.id.nav_host_fragment_article, Article(id!!)) //contenedor y fragmento
            .commit() // iniciando
    }


}