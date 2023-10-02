package com.example.tdmpa_1p_ex_76366

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtPromedioG = findViewById<TextView>(R.id.txtPromedioG)
        var txtPromedioA = findViewById<TextView>(R.id.txtPromedioA)
        var txtPromedioC = findViewById<TextView>(R.id.txtPromedioC)
        var txtPromedioS = findViewById<TextView>(R.id.txtProemdioS)
        var txtGeneral = findViewById<TextView>(R.id.txtGeneral)
        var txtAhorro = findViewById<TextView>(R.id.txtAhorro)
        var txtComida = findViewById<TextView>(R.id.txtComida)
        var txtServicios = findViewById<TextView>(R.id.txtServicios)
        var txtTotalG = findViewById<TextView>(R.id.txtTotalG)
        var txtTotalA = findViewById<TextView>(R.id.txtTotalA)
        var txtTotalC = findViewById<TextView>(R.id.txtTotalC)
        var txtTotalS = findViewById<TextView>(R.id.txtTotalS)
        var txtTotal = findViewById<TextView>(R.id.txtTotal)
        var btnPromedioG = findViewById<Button>(R.id.btnPromedioGeneral)
        var btnPromedioA = findViewById<Button>(R.id.btnPromedioAhorro)
        var btnPromedioC = findViewById<Button>(R.id.btnPromedioComida)
        var btnPromedioS = findViewById<Button>(R.id.btnPromedioServicios)
        var btnGeneral = findViewById<Button>(R.id.btnGeneral)
        var btnAhorro = findViewById<Button>(R.id.btnAhorro)
        var btnComida = findViewById<Button>(R.id.btnComida)
        var btnServicios = findViewById<Button>(R.id.btnServicios)
        var btnTotalG = findViewById<Button>(R.id.btnTotalG)
        var btnTotalA = findViewById<Button>(R.id.btnTotalA)
        var btnTotalC = findViewById<Button>(R.id.btnTotalC)
        var btnTotalS = findViewById<Button>(R.id.btnTotalS)
        var btnTotal = findViewById<Button>(R.id.btnTotal)
        btnGeneral.setOnClickListener {
            agregarCantidadesG()
            txtGeneral.text = imprimirDatosG()
        }
        btnPromedioG.setOnClickListener {
            var resultadoMedia = cantidadG.average()
            txtPromedioG.text = "$ " + resultadoMedia.toString()
        }
        btnTotalG.setOnClickListener {
            var resultado = cantidadG.sum()
            txtTotalG.text = "$ " + resultado.toString()
        }

        btnAhorro.setOnClickListener {
            agregarCantidadesA()
            txtAhorro.text = imprimirDatosA()
        }
        btnPromedioA.setOnClickListener {
            var resultadoMedia = cantidadA.average()
            txtPromedioA.text = "$ " + resultadoMedia.toString()
        }
        btnTotalA.setOnClickListener {
            var resultado = cantidadA.sum()
            txtTotalA.text = "$ " + resultado.toString()
        }

        btnComida.setOnClickListener {
            agregarCantidadesC()
            txtComida.text = imprimirDatosC()
        }
        btnPromedioC.setOnClickListener {
            var resultadoMedia = cantidadC.average()
            txtPromedioC.text = "$ " +resultadoMedia.toString()
        }
        btnTotalC.setOnClickListener {
            var resultado = cantidadC.sum()
            txtTotalC.text = "$ " + resultado.toString()
        }

        btnServicios.setOnClickListener {
            agregarCantidadesS()
            txtServicios.text = imprimirDatosS()
        }
        btnPromedioS.setOnClickListener {
            var resultadoMedia = cantidadS.average()
            txtPromedioS.text = "$ " + resultadoMedia.toString()
        }
        btnTotalS.setOnClickListener {
            var resultado = cantidadS.sum()
            txtTotalS.text = "$ " + resultado.toString()
        }

        btnTotal.setOnClickListener {
            txtTotal.text = "$ "+ totalGastos()
        }

    }

    var cantidadG : MutableList<Double> = mutableListOf()
    var cantidadA : MutableList<Double> = mutableListOf()
    var cantidadC : MutableList<Double> = mutableListOf()
    var cantidadS : MutableList<Double> = mutableListOf()


    fun agregarCantidadesG(){
        var txtCantidades = findViewById<EditText>(R.id.txtCantidad)
        cantidadG.add(txtCantidades.text.toString().toDouble())
    }
    fun agregarCantidadesA(){
        var txtCantidades = findViewById<EditText>(R.id.txtCantidad)
        cantidadA.add(txtCantidades.text.toString().toDouble())
    }
    fun agregarCantidadesC(){
        var txtCantidades = findViewById<EditText>(R.id.txtCantidad)
        cantidadC.add(txtCantidades.text.toString().toDouble())
    }
    fun agregarCantidadesS(){
        var txtCantidades = findViewById<EditText>(R.id.txtCantidad)
        cantidadS.add(txtCantidades.text.toString().toDouble())
    }

    fun imprimirDatosG () : String {
        var cadena = ""
        for (i in 0 .. cantidadG.size-1){
            cadena = cadena+("$ ${cantidadG[i]} \n")
        }
        return cadena
    }
    fun imprimirDatosA () : String {
        var cadena = ""
        for (i in 0 .. cantidadA.size-1){
            cadena = cadena+("$ ${cantidadA[i]} \n")
        }
        return cadena
    }
    fun imprimirDatosC () : String {
        var cadena = ""
        for (i in 0 .. cantidadC.size-1){
            cadena = cadena+("$ ${cantidadC[i]} \n")
        }
        return cadena
    }
    fun imprimirDatosS () : String {
        var cadena = ""
        for (i in 0 .. cantidadS.size-1){
            cadena = cadena+("$ ${cantidadS[i]} \n")
        }
        return cadena
    }

    fun totalGastos () : Double {
        var General = cantidadG.sumByDouble { it }
        var Ahorro = cantidadA.sumByDouble { it }
        var Comida = cantidadC.sumByDouble { it }
        var Servicios = cantidadS.sumByDouble { it }

        val sumaTotal = General+Ahorro+Comida+Servicios

        return sumaTotal
    }
}