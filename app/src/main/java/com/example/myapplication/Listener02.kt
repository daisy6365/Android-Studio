package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

// 익명함수/클래스
// - 이름이 없는 함수/클래스
// - 이름을 만들어줄 필요가 없다 -> 나중에 부르지 않음
// - 한번만 사용한다

class Listener02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener02)

        //뷰를 activity로 가져오는 방법
        // 1) 직접 찾아서 가져옴
        //val textView : TextView = findViewById(R.id.hello)
        // 2) xml을 import해서 가져옴
        //hello.
        var number = 10

        val hello : TextView =findViewById(R.id.hello)
        val image : ImageView =findViewById(R.id.image)
        //hello를 클릭했을때 사용자가 듣고있음
        // 1)람다 방법 (가장 많이 사용)
        hello.setOnClickListener{
            //View! == hello
            Log.d("click","Click!") //hello를 click -> logcat에 Click! 이라고 뜸
            hello.setText("안녕하세요")
            image.setImageResource(R.drawable.ic_launcher_background)
            number += 10
            Log.d("number",""+number)
        }

        // 2)익명함수 방법
        //OnClickListener -> 인터페이스
//        hello.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                Log.d("click","Click!")
//            }
//        })

        // 3) click에 이름이 필요한 방법
//        val click = object : View.OnClickListener{
//            override fun onClick(v: View?) {
//            }
//        }
//        hello.setOnClickListener(click)

        // 뷰를 조작하는 함수들
        //1) setText
        hello.setText("안녕하세요")
        //2) setImageResource
        image.setImageResource(R.drawable.ic_launcher_background)


    }
}