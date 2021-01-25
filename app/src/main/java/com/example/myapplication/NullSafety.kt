package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Null Safety
//-> Null에 대해서 안전하다
//-> 코틀린의 특징
//
//Null vs 0
//-> 0 :휴지를 다 쓰고 휴지심만 남은 상태
//-> Null : 휴지심도 없는 상태, 존재 하지 않는 상태, 모르는 상태
//
//Null이 안전하지 않은 이유
//-> 0 + 10 = 10
//-> Null + 10 = ? -> 에러
//-> button.setOnClickListener
//-> null.setOnClickListener -> 에러
//-> NullPointExceptionError 발생한다
//
//if(number != null){
//    number +10
//}
//
//if(button != null){
//    button.setOnClickListener
//}
//
//코틀린이 Null Safety하기 위해서 사용하는 문법
//-> ? : Null이 아니라면 이하 구문 실행
//-> !! : Null이 아님을 개발자 보장한다 (확실히 null이 아님)
//
//사용방법
//button?.setOnClickLinstener
//button!!.setOnClickLinstener -> null이라면 에러 발생
//
//
//Null이 될수 있는 타입
//Int, Double, Float, Class  -> Null이 될 수 없는 타입
//Int?, Double?, Float?, Class? -> Null이 될 수 있는 타입
//lateinit
//- init -> 초기값 셋팅
//- late -> 늦게 나중에
//
//-> 초기값을 나중에 셋팅 해주겠다
//-> 초기값이 셋팅 되지 않았을 때 호출을 하면 에러가 발생한다

class NullSafety : AppCompatActivity() {
    lateinit var lateCar: Car

    class Car(var number: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

//        lateCar = Car(10)
//        Log.d("number", "late number : " + lateCar.number)
//
//
//        val number: Int = 10
//        val number1: Int? = null -> null 입력해도 에러X
//
//        // !! -> 개발자가 null이 아님을 보장
//        val number5: Int = number1!! + 10
//
//
////        val number3 = number? + number1 -> XXX
//        val number3 = number1?.plus(number)
////        Log.d("number", "number3 : " + number3)
//
//        // 삼항연산자 -> 엘비스 연산자(?:)
//        // Null safety 를 위한 도구
//        val number4 = number1 ?: 10
////        Log.d("number", "number4 : " + number4)
//


    }


    fun plus(a: Int, b: Int?): Int {
        if (b != null) return a + b
        else return a
    }

    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}