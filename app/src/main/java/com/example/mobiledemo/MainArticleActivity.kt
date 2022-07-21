package com.example.mobiledemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.mobiledemo.ui.fragments.Article
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_article)

        val id = intent?.extras?.getString("id","0")
        val btnReturn = findViewById<ImageView>(R.id.btn_return)
        btnReturn.setOnClickListener {
            finish()
        }
        val fragmento = Article(id!!)
        // CONFIGURANDO UNA PANTALLA PRINCIPAL
        supportFragmentManager.beginTransaction() // configurando fragment principal
            .add(R.id.nav_host_fragment_article,fragmento ) //contenedor y fragmento
            .commit() // iniciando

        val sheet = findViewById<FrameLayout>(R.id.sheet)
        BottomSheetBehavior.from(sheet).apply {
            peekHeight=150
            this.state=BottomSheetBehavior.STATE_COLLAPSED
        }

        }


}