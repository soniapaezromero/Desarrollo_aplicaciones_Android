package com.example.desarrollo_aplicaciones_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3: AppCompatActivity(), View.OnClickListener {

    var numinic: EditText?= null
    var numfin: EditText?= null
    var primos: TextView?= null
    var calcular: Button? = null
    var inicialNumber: String? = null
    var finalNumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)
        numinic = findViewById<View>(R.id.numeroInicial) as EditText?
        numfin = findViewById<View>(R.id.numerofinal) as EditText?
        primos = findViewById<View>(R.id.resultado) as TextView?
        calcular = findViewById<View>(R.id.botoncalcular) as Button?
        calcular!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === calcular) {
            inicialNumber = numinic!!.text.toString()
            finalNumber = numfin!!.text.toString()
            primos?.setText(CalcularPrimos(inicialNumber!!, finalNumber!!))
        }
    }

    fun CalcularPrimos(primerNumero: String, numeroFinal: String): String? {
        var numero = ""
        try {
            val contador = primerNumero.toInt()
            val cantidad = numeroFinal.toInt()
            for (x in contador..cantidad) {
                if (esPrimo(x)) numero += "$x,"
            }
        } catch (nfe: NumberFormatException) {
            Toast.makeText(this, "Tienes que introducir numeros enteros", Toast.LENGTH_SHORT).show()
        }
        return numero
    }

    fun esPrimo(numero: Int): Boolean {
        var contador = 2
        var primo = true
        while (primo && contador != numero) {
            if (numero % contador == 0) primo = false
            contador++
        }
        return primo
    }
}
