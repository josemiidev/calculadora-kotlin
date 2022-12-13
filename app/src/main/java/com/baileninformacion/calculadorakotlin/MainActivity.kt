package com.baileninformacion.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.baileninformacion.calculadorakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    private var numero1 = 0.0
    private var numero2 = 0.0
    private var operacion : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operacion = null;

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btnComa.setOnClickListener(this)
        binding.btnSuma.setOnClickListener(this)
        binding.btnResta.setOnClickListener(this)
        binding.btnMultiplicar.setOnClickListener(this)
        binding.btnDividir.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnLimpiar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btn0 -> onNumberPressed("0")
            binding.btn1 -> onNumberPressed("1")
            binding.btn2 -> onNumberPressed("2")
            binding.btn3 -> onNumberPressed("3")
            binding.btn4 -> onNumberPressed("4")
            binding.btn5 -> onNumberPressed("5")
            binding.btn6 -> onNumberPressed("6")
            binding.btn7 -> onNumberPressed("7")
            binding.btn8 -> onNumberPressed("8")
            binding.btn9 -> onNumberPressed("9")
            binding.btnComa -> onNumberPressed(",")
            binding.btnSuma -> ""
            binding.btnResta -> ""
            binding.btnMultiplicar -> ""
            binding.btnDividir -> ""
            binding.btnIgual -> ""
            binding.btnLimpiar -> ""
        }
    }

    private fun onNumberPressed(number: String){
        renderScreen(number)
    }
    private fun renderScreen(numero: String){
        val result = if(binding.pantalla.text == "0" && numero != ",")
            numero
        else
            "${binding.pantalla.text}$numero"

        binding.pantalla.text = result
    }
    private fun checkOperation(){
        if(operacion == null)
            numero1 = binding.pantalla.text.toString().toDouble()
        else
            numero2 = binding.pantalla.text.toString().toDouble()
    }
}