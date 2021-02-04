package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PhoneBookDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

        //함수 호출
        getPersonInfoAndDraw()


        // 뒤로가기 아이콘 역할 부여
        val back : ImageView = findViewById(R.id.back)
        back.setOnClickListener{
            onBackPressed() //뒤로가기 함수 호출
        }
    }

    // PhoneBookActivity에서 보낸 인텐트 정보를 받음 (이름, 전화번호)
    // detail뷰에 정보 붙여넣음
    fun getPersonInfoAndDraw(){
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        // detail뷰에 해당 정보(이름, 전화번호) 넣음
        var detailname : TextView = findViewById(R.id.detail_name)
        var detailnumber : TextView = findViewById(R.id.detail_number)

        detailname.setText(name)
        detailnumber.setText(number)
    }
}