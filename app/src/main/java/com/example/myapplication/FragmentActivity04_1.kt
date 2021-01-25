package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentActivity04_1:Fragment(){
    //FragmentActivity로 가는 리스너 구현
    interface OnDataPassListener{
        fun onDataPass(data : String?)

    }
    lateinit var dataPassListener : OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("Life_cycle","onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life_cycle","onCreate")
        super.onCreate(savedInstanceState)

    }

    //뷰를 그리는 역
    override fun onCreateView(
        inflater: LayoutInflater, // 뷰를 그려주는 역할
        container: ViewGroup?, // 부모뷰
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Life_cycle","onCreateView")
        //프라그먼트가 인터페이스를 처음으로 그릴때 호출
        return inflater.inflate(R.layout.activity_fragment04_1,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life_cycle","onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        //Activity의 Oncreate에서 했던 작업을 여기에서 한다
        val pass : Button = view.findViewById(R.id.pass)
        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life_cycle","onActivityCreated")
        val data = arguments?.getString("hello")
        if (data != null) {
            Log.d("data",data)
        }
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Life_cycle","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life_cycle","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life_cycle","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life_cycle","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Life_cycle","onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Life_cycle","onDetach")
        super.onDetach()
    }
}