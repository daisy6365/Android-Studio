package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        // SharedPreference 에 저장하는 방법
        // Mode
        // - MODE_PRIVATE : 생성한 application에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 application 사용 가능 -> 읽을수만 있다
        // - MODE_WORLD_WRITABLE : 다른 application 사용 가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference에 신규로 추가
        // 에디터를 만듦
//        val editor: SharedPreferences.Editor = sharedPreference.edit()
//        editor.putString("hello", "안녕하세요") // 에디터를 이용해서 데이터를 넣어줌
//        editor.commit() //commit 꼭해줘야함 -> 데이터 들어감

        //sp1 -> Sharedpreference
        //      (Key,Value) -> ("Hello", "안녕하세요")
        //sp2 -> Sharedpreference
        //      (Key,Value) -> ("Hello", "안녕하세요11")

        val save_btn : Button = findViewById(R.id.save_btn)
        val load_button : Button = findViewById(R.id.load_button)
        val delete_button : Button = findViewById(R.id.delete_button)
        val delete_all_button : Button = findViewById(R.id.delete_all_button)

        save_btn.setOnClickListener {
            //이름과 Mode 입력
            //저장 버튼
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()

            // hello, goodbye 데이터 저장
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕하가세요")
            editor.commit()
        }


        load_button.setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            // 데이터 불러오기 버튼
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음1")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음2")
            // Logcat에 데이터 불러옴
            Log.d("key-value", "Value 1 : " + value1)
            Log.d("key-value", "Value 2 : " + value2)
        }

        delete_button.setOnClickListener {
            // 부분 삭제 버튼
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            // hello 특정키 삭제
            editor.remove("hello")
            editor.commit()
        }

        delete_all_button.setOnClickListener {
            // 전체 삭제 버튼
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            // clear -> 전체 삭제
            editor.clear()
            editor.commit()
        }
    }
}