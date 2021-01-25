package com.example.myapplication
//Thread(쓰레드)
//- 작업 흐름
//
//앱실행 -----> launcher Activity -----> ----> ------> 작업흐름
//
//안드로이드의 쓰레드
//-> MainThread
//-------------------------------------------------------------->
//    -> launcher Activity
//                         -> Activity B
//                                        -> 영상 재생
//                                                    -> 기타등등
//
//할일 : 더하기, 빼기, 곱하기, 나누기
//MainThread만 있는 경우
//-------------------------------------------------------------->
//---------> 더하기  ---------> 빼기 ---------> 곱하기 ---------> 나누기
//
//다른 쓰레드가 있는 경우  -> 여러가지 일을 한번에 할 수 있다
//-------------------------------------------------------------->
//              빼기
//              ------------------>
//                        곱하기
//                        ------------------->
//     더하기
//     ------------------------------------------------------>
//                                                  나누기
//                                                  -------------->
//안드로이드 MainThread의 특징
//- UI(User Interface) Thread
//    - 사용자의 input을 받는 쓰레드
//- 절대 정지시킬수 없다!!(하면 안된다!)
//    - 왜냐하면, 정지 시키거나 종료 시키면 더 이상 사용자의 input을 받을수 없기 때문!

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi

class ThreadActivity07 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread07)
        val button : Button = findViewById(R.id.button)

        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread1 is made")
            }
        }
        //thread를 만들고 Thread안에 runnable 넣어줘야함
        val thread: Thread = Thread(runnable)

        //thread 실행
        button.setOnClickListener {
            thread.start()
        }


        //Thread 실행 짧은 코드
        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread2 is made")
            }
        }).start()

        //Thread 실행 짧은 코드
        Thread(Runnable {
            Thread.sleep(2000) //thread3을 2초동안 잠재움
            Log.d("thread-1", "Thread3 is made")

            // Thread가 실행될때 만들어 놓은 button background 색상 변경
            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.design_default_color_background))
            }// main thread에서 돌아가는 thread
        }).start()
    }
}