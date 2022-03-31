package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InformacionEstudianteActivity : AppCompatActivity() {

    var nombreCom: TextView?= null

    /*Subject and Gradle Student*/
    var nombreN1: TextView?= null
    var nombreN2: TextView?= null
    var nombreN3: TextView?= null
    var nombreN4: TextView?= null
    var nombreN5: TextView?= null

    var nota1: TextView?= null
    var nota2: TextView?= null
    var nota3: TextView?= null
    var nota4: TextView?= null
    var nota5: TextView?= null

    /*Status and Average*/
    var promedioAverage: TextView?= null

    var mapaMaterias: TextView?= null

    /*Operation*/
    var operaciones:GuardarEstadistica?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion_estudiante)

        getDatos()
    }
    private fun getDatos(){
        operaciones = GuardarEstadistica()

        /*Name Student*/
        nombreCom = findViewById(R.id.txtNombre)

        /*Subject and Grade*/
        nombreN1 = findViewById(R.id.txtNombreN1)
        nombreN2 = findViewById(R.id.txtNombreN2)
        nombreN3 = findViewById(R.id.txtNombreN3)
        nombreN4 = findViewById(R.id.txtNombreN4)
        nombreN5 = findViewById(R.id.txtNombreN5)

        nota1 = findViewById(R.id.txtNota1)
        nota2 = findViewById(R.id.txtNota2)
        nota3 = findViewById(R.id.txtNota3)
        nota4 = findViewById(R.id.txtNota4)
        nota5 = findViewById(R.id.txtNota5)

        /*Average And Status*/
        promedioAverage = findViewById(R.id.txtPromedio)

        mapaMaterias = findViewById(R.id.txtEstadistica)

        mostrarDatos()
    }
    private fun mostrarDatos(){
        var miBundlde:Bundle? = this.intent.extras

        if (miBundlde!=null) {

            nombreCom!!.text = "${miBundlde.get("nombreCom")}"

            nombreN1!!.text = "${miBundlde.get("nombreN1")}"
            nombreN2!!.text = "${miBundlde.get("nombreN2")}"
            nombreN3!!.text = "${miBundlde.get("nombreN3")}"
            nombreN4!!.text = "${miBundlde.get("nombreN4")}"
            nombreN5!!.text = "${miBundlde.get("nombreN5")}"

            nota1!!.text = "${miBundlde.get("nota1")}"
            nota2!!.text = "${miBundlde.get("nota2")}"
            nota3!!.text = "${miBundlde.get("nota3")}"
            nota4!!.text = "${miBundlde.get("nota4")}"
            nota5!!.text = "${miBundlde.get("nota5")}"

            promedioAverage!!.text = "${miBundlde.get("promedioAverage")}"
            mapaMaterias!!.text = "${miBundlde.get("mapaMaterias")}"
        }
    }
}