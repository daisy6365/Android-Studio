package com.example.myapplication.Kotlin


// 변수의 접근 범위
// 1. 전역 변수
// 2. 지역 변수

//전역변수
var number100: Int = 10


fun main(args: Array<String>) {
    println(number100)

    //변수 실체화
    val test = Test("홍길동")
    test.testFun()
    println(test.name)
    println(number100)

}


//지역 변수
//class 안에서만 접근이 가능
class Test(var name: String) {

    //birth는 testFun범위 내에서만 사용이 가능
    fun testFun() {
        var birth: String = "2000/3/1"
        name = "홍길동"
        number100 = 100

        //testFun2 밖에서는 gender변수 사용XX
        fun testFun2() {
            var gender: String = "male"
        }
    }

    fun testFun2() {
        name
//        birth
    }
}