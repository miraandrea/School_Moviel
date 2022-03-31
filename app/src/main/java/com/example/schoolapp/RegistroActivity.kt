package com.example.schoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {

    var documento: EditText?= null
    var nombreCompleto: EditText?= null
    var edad: EditText?= null
    var telefono: EditText?= null
    var direccion: EditText?= null

    var nombreN1: EditText?= null
    var nombreN2: EditText?= null
    var nombreN3: EditText?= null
    var nombreN4: EditText?= null
    var nombreN5: EditText?= null

    var nota1: EditText?= null
    var nota2: EditText?= null
    var nota3: EditText?= null
    var nota4: EditText?= null
    var nota5: EditText?= null

    var operaciones:GuardarEstadistica?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        inicioComponentes()
    }

    private fun inicioComponentes() {

        operaciones = GuardarEstadistica()

        documento = findViewById(R.id.editDocumento)
        nombreCompleto = findViewById(R.id.editNombreCom)
        edad = findViewById(R.id.editEdad)
        telefono = findViewById(R.id.editTelefono)
        direccion = findViewById(R.id.editDireccion)

        nombreN1 = findViewById(R.id.editNombreN1)
        nombreN2 = findViewById(R.id.editNombreN2)
        nombreN3 = findViewById(R.id.editNombreN3)
        nombreN4 = findViewById(R.id.editNombreN4)
        nombreN5 = findViewById(R.id.editNombreN5)

        nota1 = findViewById(R.id.editNota1)
        nota2 = findViewById(R.id.editNota2)
        nota3 = findViewById(R.id.editNota3)
        nota4 = findViewById(R.id.editNota4)
        nota5 = findViewById(R.id.editNota5)

        val btnGuardar: Button = findViewById(R.id.btnAddRegistro)
        btnGuardar.setOnClickListener { EstudianteNuevo() }
    }

    private fun EstudianteNuevo() {
        var datos: DatosEstudiantes = DatosEstudiantes()

        datos.documento = documento?.text.toString()
        datos.nombreCom = nombreCompleto?.text.toString()
        datos.edad = edad?.text.toString().toInt()
        datos.telefono = telefono?.text.toString()
        datos.direccion = direccion?.text.toString()

        datos.nombreN1 = nombreN1?.text.toString()
        datos.nombreN2 = nombreN2?.text.toString()
        datos.nombreN3 = nombreN3?.text.toString()
        datos.nombreN4 = nombreN4?.text.toString()
        datos.nombreN5 = nombreN5?.text.toString()

        datos.nota1 = nota1?.text.toString().toDouble()
        datos.nota2 = nota2?.text.toString().toDouble()
        datos.nota3 = nota3?.text.toString().toDouble()
        datos.nota4 = nota4?.text.toString().toDouble()
        datos.nota5 = nota5?.text.toString().toDouble()

        /*datos.promedio= operaciones!!.promedio(datos)

        operaciones?.registroEstudiante(datos)

        operaciones?.imprimirListaEstudiantes()*/
        datos.promedioAverage = operaciones!!.promedio(datos)
        datos.mapaMaterias = operaciones!!.estadistica(datos)

        operaciones?.registroEstudiante(datos)
        informacion(datos)
    }
    private fun informacion(datos:DatosEstudiantes){
        val intent = Intent(this, InformacionEstudianteActivity::class.java)
        val miBundle: Bundle = Bundle()

        miBundle.putString("nombreCom", datos.nombreCom)

        miBundle.putString("nombreN1", datos.nombreN1)
        miBundle.putString("nombreN2", datos.nombreN2)
        miBundle.putString("nombreN3", datos.nombreN3)
        miBundle.putString("nombreN4", datos.nombreN4)
        miBundle.putString("nombreN5", datos.nombreN5)

        miBundle.putDouble("nota1", datos.nota1)
        miBundle.putDouble("nota2", datos.nota2)
        miBundle.putDouble("nota3", datos.nota3)
        miBundle.putDouble("nota4", datos.nota4)
        miBundle.putDouble("nota5", datos.nota5)

        miBundle.putDouble("promedioAverage", datos.promedioAverage)
        miBundle.putString("mapaMaterias", datos.mapaMaterias)

        intent.putExtras(miBundle)
        startActivity(intent)
    }
}