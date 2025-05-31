package com.example.csyapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val inputA = findViewById<EditText>(R.id.inputA)
        val inputB = findViewById<EditText>(R.id.inputB)
        val resultText = findViewById<TextView>(R.id.resultText)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        fun getInputs(): Pair<Double, Double>? {
            val a = inputA.text.toString()
            val b = inputB.text.toString()
            return if (a.isNotEmpty() && b.isNotEmpty()) {
                Pair(a.toDouble(), b.toDouble())
            } else {
                Toast.makeText(this, "Isi kedua nilai terlebih dahulu", Toast.LENGTH_SHORT).show()
                null
            }
        }

        btnAdd.setOnClickListener {
            getInputs()?.let { (a, b) -> resultText.text = (a + b).toString() }
        }

        btnMultiply.setOnClickListener {
            getInputs()?.let { (a, b) -> resultText.text = (a * b).toString() }
        }

        btnDivide.setOnClickListener {
            getInputs()?.let { (a, b) ->
                if (b != 0.0) {
                    resultText.text = (a / b).toString()
                } else {
                    Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}