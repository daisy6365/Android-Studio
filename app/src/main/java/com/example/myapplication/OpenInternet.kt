package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

//인터넷주소를 입력하는 칸 (editText -> 리스너(적히는 리스너))
//인터넷 페이지 열기 버튼 -> 누르면 해당 인터넷주소로 이동

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)

        var edit: EditText = findViewById(R.id.Edit1)
        val button: Button = findViewById(R.id.button1)

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(edit.text.toString()))
            startActivity(intent)
        }

        //edittext에 텍스트의 변화를 폴더로 받을 수 있는 리스너
        edit.addTextChangedListener(object : TextWatcher{
            //텍스트가 모두 변화된 후에 -> editable
            override fun afterTextChanged(s: Editable?) {
                Log.d("edit","afterTextChanged:"+ s )
            }

            // 텍스트가 변화되기 전에
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit","beforeTextChanged:"+ s )
            }

            // 텍스트가 변화하고 있을 때
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit","onTextChanged:"+ s )
            }
        })
    }
}