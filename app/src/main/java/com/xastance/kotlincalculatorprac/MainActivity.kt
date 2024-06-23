package com.xastance.kotlincalculatorprac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvWorking: TextView

    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnDecPoint: Button

    private lateinit var btnClearAll: Button
    private lateinit var btnPercent: Button
    private lateinit var btnBackSpace: Button
    private lateinit var btnDivide: Button
    private lateinit var btnTimes: Button
    private lateinit var btnMinus: Button
    private lateinit var btnPlus: Button
    private lateinit var btnEquals: Button

    private var strEquation1: String = "0"
    private var strEquation2: String = ""
    private var lastOperation: String? = null
    private var isResultDisplayed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewIds()

        setOnClickListeners()
    }

    private fun appendNumber(str: String) {
        if (isResultDisplayed) {
            strEquation1 = ""
            isResultDisplayed = false
        }

        if (strEquation1 == "0" && str != ".") {
            strEquation1 = ""
        }

        if (str == "." && strEquation1.contains(".")) {
            return
        }

        strEquation1 += str
        tvResult.text = strEquation1
    }

    private fun backSpaceDigits() {
        strEquation1 = strEquation1.dropLast(1)
        if (strEquation1.isEmpty()){
            strEquation1 = "0"
        }
        tvResult.text = strEquation1
    }

    private fun clearAll() {
        strEquation1 = "0"
        strEquation2 = ""
        tvResult.text = strEquation1
        tvWorking.text = ""
        lastOperation = null
        isResultDisplayed = false
    }

    private fun performOperation(op: String) {
        if (lastOperation != null && strEquation1.isNotEmpty()) {
            calculateResult()
        } else {
            strEquation2 = strEquation1
        }
        lastOperation = op
        strEquation1 = "0"
        tvWorking.text = "$strEquation2 $op"
    }

    private fun calculateResult() {
        val num1 = strEquation2.toDouble()
        val num2 = strEquation1.toDouble()
        val result = when (lastOperation) {
            "\u002B" -> num1 + num2
            "\u2212" -> num1 - num2
            "\u00D7" -> num1 * num2
            "\u00F7" -> num1 / num2
            "\u0025" -> num1 % num2
            else -> num2
        }
        strEquation1 = if (result % 1 == 0.0) {
            result.toInt().toString()
        } else {
            result.toString()
        }
        strEquation2 = result.toString()
        tvResult.text = strEquation1
        tvWorking.text = ""
        lastOperation = null
        isResultDisplayed = true
    }

    private fun setViewIds() {
        tvResult = findViewById(R.id.tvResult)
        tvWorking = findViewById(R.id.tvWorking)

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnDecPoint = findViewById(R.id.btnDecPoint)

        btnPercent = findViewById(R.id.btnPercent)
        btnDivide = findViewById(R.id.btnDivide)
        btnTimes = findViewById(R.id.btnTimes)
        btnMinus = findViewById(R.id.btnMinus)
        btnPlus = findViewById(R.id.btnPlus)

        btnEquals = findViewById(R.id.btnEquals)

        btnClearAll = findViewById(R.id.btnClearAll)
        btnBackSpace = findViewById(R.id.btnBackSpace)

        tvResult.text = strEquation1
    }

    private fun setOnClickListeners() {
        btn0.setOnClickListener { appendNumber("0") }
        btn1.setOnClickListener { appendNumber("1") }
        btn2.setOnClickListener { appendNumber("2") }
        btn3.setOnClickListener { appendNumber("3") }
        btn4.setOnClickListener { appendNumber("4") }
        btn5.setOnClickListener { appendNumber("5") }
        btn6.setOnClickListener { appendNumber("6") }
        btn7.setOnClickListener { appendNumber("7") }
        btn8.setOnClickListener { appendNumber("8") }
        btn9.setOnClickListener { appendNumber("9") }
        btnDecPoint.setOnClickListener { appendNumber(".") }

        btnPercent.setOnClickListener { performOperation("\u0025") }
        btnDivide.setOnClickListener { performOperation("\u00F7") }
        btnTimes.setOnClickListener { performOperation("\u00D7") }
        btnMinus.setOnClickListener { performOperation("\u2212") }
        btnPlus.setOnClickListener { performOperation("\u002B") }

        btnEquals.setOnClickListener { calculateResult() }

        btnClearAll.setOnClickListener{clearAll()}
        btnBackSpace.setOnClickListener{backSpaceDigits()}
    }

}
