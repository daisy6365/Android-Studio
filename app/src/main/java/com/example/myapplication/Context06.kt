package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//Context
//역할 -> ActivityManagerService(개발하기 편하도록 미리 구현 해놓은 기능)에 접근 하도록 해주는 역할
//-> 주변정보
//
//
//안드로이드는 이미 많은 부분들이 만들어져 있다 -> 이런것들 사용하기 위해서는 Context가 필요한 경우가 많다
//
//
//
//종류
//- acitivty의 context(주변정보) -> Activity의 주변 정보
//- application의 context(주변정도) -> Application의 주변 정보
//- ApplicationContext > ActivityContext

class Context06 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context06)


        val context: Context = this
        val applicationContext = getApplicationContext()


    }
}