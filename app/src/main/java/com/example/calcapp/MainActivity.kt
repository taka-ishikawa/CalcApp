package com.example.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {

    var doubleNumberLeft: Double = 0.0
    var doubleNumberRight: Double = 0.0
    var doubleAnswer: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDevide.setOnClickListener(this)
        editTextLeft.addTextChangedListener(this)
        editTextRight.addTextChangedListener(this)
    }

    override fun onClick(v: View?) {
        if (editTextLeft.text.toString() == "" || editTextRight.text.toString() == ""){
            Toast.makeText(this, "数値を入力してください。", Toast.LENGTH_LONG).show()
        } else {
            doubleNumberLeft = editTextLeft.text.toString().toDouble()
            doubleNumberRight = editTextRight.text.toString().toDouble()

            when(v?.id){
                R.id.buttonPlus -> doubleAnswer = doubleNumberLeft + doubleNumberRight
                R.id.buttonMinus -> doubleAnswer = doubleNumberLeft - doubleNumberRight
                R.id.buttonMultiply -> doubleAnswer = doubleNumberLeft * doubleNumberRight
                R.id.buttonDevide -> doubleAnswer = doubleNumberLeft / doubleNumberRight
            }

            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra(getString(R.string.intent_key_double_answer), doubleAnswer)
            startActivity(intent)
        }
    }

//    こうしたい　e.g. editText 0032 -> 32

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//        editTextLeft.text
//        editTextLeft.toString().toDouble().toString() = TextView.BufferType
    }
}