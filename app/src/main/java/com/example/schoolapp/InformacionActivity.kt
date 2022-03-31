package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class InformacionActivity : AppCompatActivity() {

    var RegistroEstudiantes: TextView?= null
    var GanaronEstudiantes: TextView?= null
    var PerdieronEstudiantes: TextView?= null
    var RecuperarEstudiantes: TextView?= null

    var operaciones: GuardarEstadistica?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        informacionDatos()
    }
    private fun informacionDatos() {

        operaciones = GuardarEstadistica()

        RegistroEstudiantes = findViewById(R.id.Registados)
        GanaronEstudiantes = findViewById(R.id.Ganaron)
        PerdieronEstudiantes = findViewById(R.id.Perdieron)
        RecuperarEstudiantes = findViewById(R.id.Recuperar)

        verDatos()

    }
    private fun verDatos(){

        RegistroEstudiantes!!.text = operaciones!!.CuantosEstudiantes().toString()
        GanaronEstudiantes!!.text = operaciones!!.estadisticaNota("El estudiante gano el año").toString()
        PerdieronEstudiantes!!.text = operaciones!!.estadisticaNota("El etudiante perdio el año").toString()
        RecuperarEstudiantes!!.text = operaciones!!.estadisticaNota("El estudiante puede recuperar").toString()

    }
}