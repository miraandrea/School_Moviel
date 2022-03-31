package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    val duracion : Long = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val logo = findViewById<ImageView>(R.id.colegio)

        cambiarActivity()
        }
        private fun cambiarActivity() {
            Handler().postDelayed(Runnable {
                startActivity(Intent(this, MenuActivity::class.java))
            }, duracion)
    }
}