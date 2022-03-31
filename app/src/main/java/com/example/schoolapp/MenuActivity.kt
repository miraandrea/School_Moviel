package com.example.schoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        iniciar()
    }

    private fun iniciar() {

        val BtnRegistrar: Button = findViewById(R.id.btnRegistrar)
        val BtnInformacion: Button = findViewById(R.id.btnInformacion)
        val BtnAyuda: Button = findViewById(R.id.btnAyuda)

        BtnRegistrar.setOnClickListener { onClick(1) }
        BtnInformacion.setOnClickListener { onClick(2) }
        BtnAyuda.setOnClickListener { onClick(3) }
    }

    private fun onClick(boton: Int) {
        when (boton) {
            1 -> {
                val intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, InformacionActivity::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this, AyudaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}