package com.example.myapplication
//Fragment
//
//- Activity -> 앱에 보이는 한 화면의 단위
//
//- 엑비티가 가지고 있는 문제
//    - ex)
//    - 엑티비티가 길어지게 되면 (파트1,2,3,4,5,6) -> 관리 포인트가 많아진다 -> 관리가 어려워진다
//
//- 다양한 디바이스에서 오는 문제
//    - ex)
//    - 안드로이드 디바이스가 너무 다양하다
//    - 안드로이드에는 핸드폰만 있는게 아니다! -> 테블릿이 있다!
// => Fragment가 필요!
//사용처
//- 엑티비티의 파트를 나누어서 책임진다
//
//Fragment
//- 라이프 사이클이 존재한다
//- 엑티비티 종속적이다
//
//사용방법
//- XML에 ViewComponent로 추가한다 <Fragment/>
//- 코드로(동적)으로 추가한다
//
//데이터 전달 방법
//- Activity -> Fragment : argument 와 bundle
//- Fragment -> Activity : 자체 구현(리스너 구현)
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager

class FragmentActivity04 : AppCompatActivity() , FragmentActivity04_1.OnDataPassListener {
    override fun onDataPass(data: String?) {
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment04)
        Log.d("Life_cycle","onCreate")


        val button : Button = findViewById(R.id.button)
        val button2 : Button = findViewById(R.id.button2)

        //버튼 2개를 한꺼번에 적용시키기 위해서 -> 리스너 바깥에 프라그먼트 생성
        val FragmentActivity04_1: FragmentActivity04_1 = FragmentActivity04_1()
        // 프라그먼트에 data를 넣어주는 방법
        // 인텐트 -> putExtra() 사용
        // 프라그먼트 -> bundle() 사용
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "hello")
        FragmentActivity04_1.arguments = bundle // 프라그먼트에 번들 할

        button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // 프라그먼트 붙이는 방법 replace/add
            val fragmentManager: FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() //시작
            //할일
            //replace, add
            fragmentTransaction.replace(R.id.container, FragmentActivity04_1) //뷰 자리에 프라그먼트가 대체
            fragmentTransaction.commit() //끝을 내줘야 완벽하게 화면 출력
            // 끝을 내는 방법
            // commit     -> 시간 될 때 해 (좀더 안정정)
            // commitnow  -> 지금 당장해
        }

        button2.setOnClickListener {
            // 프라그먼트 remove/detach 하는 방법
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            //fragmentTransaction.detach(FragmentActivity04_1)
            // --> 아예 제거
            fragmentTransaction.remove(FragmentActivity04_1) //다시 붙일 수 있음
            fragmentTransaction.commit()
        }

    }
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