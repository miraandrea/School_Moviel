package com.example.schoolapp

class GuardarEstadistica {

    companion object {
        var infoEstudiante = arrayListOf<DatosEstudiantes>()
    }

    fun registroEstudiante(datos: DatosEstudiantes) {
        infoEstudiante.add(datos)
    }

    fun CuantosEstudiantes(): Int {
        return infoEstudiante.count()
    }
    fun promedio(datos: DatosEstudiantes): Double{
        return (datos.nota1 + datos.nota2 + datos.nota3 + datos.nota4 + datos.nota5)/5
    }
    fun estadistica(datos: DatosEstudiantes):String{
        var resuldado= ""
        if(datos.promedioAverage > 3.5){ resuldado = "El estudiante gano el año" }
        else if(datos.promedioAverage > 2.5){ resuldado="El estudiante puede recuperar" }
        else{ resuldado="El etudiante perdio el año" }
        return resuldado
    }

    fun estadisticaNota(nota:String):Int{
        var contador:Int=0
        for (estudiante in infoEstudiante){
            if(estudiante.mapaMaterias === nota){
                contador += 1
            }
        }
        return contador
    }

}