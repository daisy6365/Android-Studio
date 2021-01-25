package com.example.myapplication
//Framework
//- 안드로이드 스튜디오
//- 개발을 하기위해 지켜하는 틀
//
//
//Library (외부의 도움)
//- 개발을 하기 위해 필요한 도구들이 미리 구현되어 있는 것
//- 함수나, 클래스로 구현이 되어 있습니다
//- 프레임워크에 없다!
//
//- 특징
//    - 프레임워크에서 하기 힘든 것들을 쉽게 사용할수 있도록 만들어 놨다!
//    - 프레임워크에서 제공하지 않는 기능을 사용할 수 있도록 만들어 놨다!

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val glide : ImageView = findViewById(R.id.glide)
        val glide2 : ImageView = findViewById(R.id.glide2)

        Glide.with(this@LibraryActivity)
                //안에 있는 것을 불러옴 -> load한것을 이미지뷰에 불러옴
                //해당 URL은 인터넷을 사용해서 불러와야함 -> permission 필요
           .load("https://image.laftel.net/items/thumbs/large/f3203d2d-13e7-43fc-afb0-a43a9a5fe56b.jpg")
            .centerCrop() //위치를 조정할 수 있는 함수 -> 영역 조정 200dp*200dp를 꽉 채움
            .into(glide)


        Glide.with(this@LibraryActivity)
            .load("https://image.laftel.net/items/thumbs/large/f3203d2d-13e7-43fc-afb0-a43a9a5fe56b.jpg")
            .into(glide2)
    }
}