package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operator: String = ""

    private var secOperand: Double = 0.0

    private var dotPressed: Boolean = false
    private var reset: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View){
        if(view is TextView){

            var result: String = resultTextView.text.toString()
            val number: String = view.text.toString()


            if(result == "0"){
                result = ""
            }
            if(reset == true){
                resultTextView.text = number
                dotPressed = false
            }
            else {
                resultTextView.text = result + number
            }
            reset = false
        }
    }

    fun operatorClick(view: View){
        if(view is TextView){
            if (!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }

            operator = view.text.toString()

            resultTextView.text = ""
            dotPressed = false
        }
    }

    fun equalsClick(view: View){
        if(view is TextView){
            val secOperandText: String = resultTextView.text.toString()

            if(!TextUtils.isEmpty(resultTextView.text)){
                secOperand = secOperandText.toDouble()
                reset = true
                dotPressed = true
            }
            when(operator){
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
            }

        }
    }

    fun dotClick(view: View){
        if(view is TextView){
            if(!TextUtils.isEmpty(resultTextView.text)){
                if(dotPressed == false) {
                    resultTextView.text = resultTextView.text.toString() + "."
                    dotPressed = true
                }
            }
        }
    }

    fun clearClick(view: View){
        if (view is TextView){
            secOperand = 0.0
            resultTextView.text = ""
        }
    }

    fun delClick(view: View){
        if(view is TextView){
            val resultInStr: String = resultTextView.text.toString()

            if(!TextUtils.isEmpty(resultTextView.text)){
                resultTextView.text = resultInStr.substring(0,resultInStr.length - 1)
            }

        }
    }
}