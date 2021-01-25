package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

// 더하기 계산기 만들기
// CA -> 초기화 버튼
// 1000의 자리 까지

class Caculator_practice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caculator_practice)

        var textView : TextView = findViewById(R.id.textview1)

        val one: TextView = findViewById(R.id.one)
        val two: TextView = findViewById(R.id.two)
        val three: TextView = findViewById(R.id.three)
        val four: TextView = findViewById(R.id.four)
        val five: TextView = findViewById(R.id.five)
        val six: TextView = findViewById(R.id.six)
        val seven: TextView = findViewById(R.id.seven)
        val eight: TextView = findViewById(R.id.eight)
        val nine: TextView = findViewById(R.id.nine)
        val zero: TextView = findViewById(R.id.zero)

        val plus: TextView = findViewById(R.id.plus)
        var ca: TextView = findViewById(R.id.CA)

        var new = "0"
        var old = "0"

        one.setOnClickListener{
            new = new + "1"
            textView.setText(new)
        }

        two.setOnClickListener{
            new = new + "2"
            textView.setText(new)
        }

        three.setOnClickListener{
            new = new + "3"
            textView.setText(new)
        }

        four.setOnClickListener{
            new = new + "4"
            textView.setText(new)
        }

        five.setOnClickListener{
            new = new + "5"
            textView.setText(new)
        }

        six.setOnClickListener{
            new = new + "6"
            textView.setText(new)
        }

        seven.setOnClickListener{
            new = new + "7"
            textView.setText(new)
        }

        eight.setOnClickListener{
            new = new + "8"
            textView.setText(new)
        }

        nine.setOnClickListener{
            new = new + "9"
            textView.setText(new)
        }

        zero.setOnClickListener{
            new = new + "0"
            textView.setText(new)
        }


        plus.setOnClickListener{
            old = (old.toInt() + new.toInt()).toString()
            new = "0"
            textView.setText(old)

        }

        ca.setOnClickListener {
            new = "0"
            old = "0"
            textView.setText("0")
        }
    }
}