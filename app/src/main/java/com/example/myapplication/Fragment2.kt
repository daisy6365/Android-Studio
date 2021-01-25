package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, // 뷰를 그려주는 역할
        container: ViewGroup?, // 부모뷰
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Life_cycle","onCreateView")
        //프라그먼트가 인터페이스를 처음으로 그릴때 호출
        return inflater.inflate(R.layout.activity_fragment04_1,container,false)
    }
}