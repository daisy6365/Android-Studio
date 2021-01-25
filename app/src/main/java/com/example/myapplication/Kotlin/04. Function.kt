package com.example.myapplication.Kotlin

//04. Function
// - 어떤 input을 넣어주면 어떤 output 나옴
// fun 함수명 (변수명 : 타입, 변수명 : 타입 ....) : 반환형 {
//      함수 내용
//      return 반환값
// }

//함수 생성
fun plus(first : Int, second: Int):Int {
    val result : Int = first + second
    return result
}

//-디폴트 값을 갖는 함수 만들기
fun plusFive(first: Int, second: Int = 5):Int{
    val result : Int = first + second
    return result
}

//-반환값이 없는 함수 만들기
// Unit -> 아무것도 반환하지 않음(생략가능)
fun printplus(first:Int, second: Int):Unit{
    val result : Int = first + second
    println(result)
}

//간단하게 함수를 선언하는 방법
fun plusShort (first: Int,second: Int) = first + second

//가변인자를 갖는 함수 선언하는 방법
//1개~n개 까지의 인자를 얻을 수 있음
fun plusMany(vararg numbers:Int) {
    for (number in numbers) {
        println(number)
    }
}

fun main (array: Array<String>){
    val result = plus(5, 10) //5+10 -> 15 출력
    //순서를 바꿀때에는 명시적으로 인자를 정해줌
    val result2 = plus(second = 20, first = 30) // 50 출력
    println(result)
    println(result2)

    val result3 = plusFive(10, 20)
    println(result3)
    val result4 = plusFive(10)
    println(result4)

    println()
    printplus(10,20)

    println()
    val result5 = plusShort(50, 50)
    println(result5)

    println()
    plusMany(5,10,15)
}