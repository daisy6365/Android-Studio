package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

// 03. Intent
//  - 의도, 요구, 의사 전달, 요청
//  - Intent 사용
//      - Acitivty 와 Activity 사이에 의사 전달, 요청
//      - Android System 과 내 App (전화) (앱 -> 핸드폰내에 있는 전화기능)
//      - 다른 App 과 내 App -> 무작정 사용할수 없다, 상호합의가 있어야 한다 (배달앱 결제 -> 은행 앱)


//  - 요청의 종류
//      - 전달만 하는 요청
//      - 리턴을 받는 요청

//  - 인텐트의 종류
//      - 명시적 인텐트 -> 정확히 대상에게 요청
//      - 암시적 인텐트 -> 할 수 있는 대상에 요청

class Intent03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent03)

        var change_activity : Button = findViewById(R.id.change_activity)

        change_activity.setOnClickListener {
            //Intent03에서 버튼 클릭 -> Intent03_2로 이동
//            val intent = Intent(this@Intent03,Intent03_2 :: class.java) //인텐트 생성
            startActivity(intent)

//            Context
//            - 문맥
//            - 엑티비티가 가지고 있는 주변 정보

            //인텐트에 정보를 담아서 보내기
            //Key, Value 방식 -> Key와 Value를 쌍으로 만들어 저장한다. -> Dictionary
            //intent.putExtra("number1",1)
            //intent.putExtra("number2",2)
            //startActivity(intent)
            //-> 받는쪽으로 가서 (Intent03_2) intent에 담긴 extra를 꺼낸다.

//            val intent2 = Intent(this@Intent03,Intent03_2 :: class.java)
            //intent -> this로 바꿔 쓸수 있도록 함 =>> 블럭으로 묶으면 헷갈릴 일이 없음
//            intent2.apply {
//                this.putExtra("number1",1)
//                this.putExtra("number2",1)
//            }
            //이름을 숫자로 적어줘야함
            //리턴값을 받아내는 Activity함수 실행
//            startActivityForResult(intent2,200)

            //암시적 인텐트동 (전화, 인터넷주소 사이트 이동 ...)
            //버튼을 누르면 -> 네이버 사이트로 이동
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
            
        }
    }

    //결과 값 받기 -> override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 200){
            Log.d("number",""+requestCode)
            Log.d("number",""+resultCode)
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
        }

        super.onActivityResult(requestCode, resultCode, data)

    }
}