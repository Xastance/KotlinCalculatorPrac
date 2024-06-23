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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewIds()

        setOnClickListeners()
    }

    private fun appendNumber(str: String) {

        if(strEquation1.startsWith("0")){
            strEquation1 = ""
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
        tvResult.text = strEquation1
        tvWorking.text = ""
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

        btnPercent.setOnClickListener { appendNumber("9") }
        btnDivide.setOnClickListener { appendNumber("9") }
        btnTimes.setOnClickListener { appendNumber("9") }
        btnMinus.setOnClickListener { appendNumber("9") }
        btnPlus.setOnClickListener { appendNumber("9") }

        btnEquals.setOnClickListener { appendNumber("9") }

        btnClearAll.setOnClickListener{clearAll()}
        btnBackSpace.setOnClickListener{backSpaceDigits()}
    }

}
