package com.example.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val doubleAnswer: Double = intent.extras[getString(R.string.intent_key_double_answer)] as Double
        val doubleAnswerRounded: Double = Math.round(doubleAnswer * 100.0)/100.0

        if (doubleAnswer.toString() == "${doubleAnswer.toInt()}.0"){
            val intAnswer: Int = doubleAnswer.toInt()

            textViewAnswer.text = intAnswer.toString()
        } else{
            textViewAnswer.text = doubleAnswerRounded.toString()
        }

        buttonBack.setOnClickListener{
            finish()
        }
    }
}
