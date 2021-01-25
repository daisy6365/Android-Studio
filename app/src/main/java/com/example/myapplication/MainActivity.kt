package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //화면을 그림

        Log.d("Life_cycle","onCreate")
    }

    //log -> 어떤 행동이 발생했을때 기록(로그인, 로그아웃)
    override fun onStart() {
        super.onStart()
        Log.d("Life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life_cycle","onDestroy")
    }
}