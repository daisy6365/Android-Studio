package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Intent03_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent03_2)

        //타입을 지정해줘야함 //defaultValue 값도 지정해야함(아무거나)
        val number1 = intent.getIntExtra("number1",0)
        val number2 = intent.getIntExtra("number2",0)

        Log.d("number",""+number1)//스트링 형태로 출력
        Log.d("number",""+number2)

    }
}