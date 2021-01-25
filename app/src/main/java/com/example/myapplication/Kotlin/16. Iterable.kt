package com.example.myapplication.Kotlin

// 16. Iterable
//반복문

fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)


    // 반복하는 방법 (1)
    for (item in a) { //1~9까지 반복
        if (item == 5) {
            println("item is Five")
        } else {
            println("item is not Five")
        }
    }
    println()

    // 반복하는 방법 (2)
    for ((index, item) in a.withIndex()) { //순서&값을 알려줌
        println("index : " + index + " value : " + item) //전부다 문자열로 변경
        // 문자열 + Int(정수) = 문자열
        // 문자열 + 아무거나  = 문자열
    }
    println()

    // 반복하는 방법 (3)
    a.forEach {
        println(it) //item
    }
    println()

    // 반복하는 방법 (4)
    a.forEach { item ->
        println(item) //it의 이름을 바꿈
    }
    println()

    // 반복하는 방법 (5)
    a.forEachIndexed { index, item ->
        println("index : " + index + " value : " + item) //순서&값
    }

    // 반복하는 방법 (6)
    println(a.size) //9

    println()
    for (i in 0 until a.size) { //0부터 9를 포함하지 않는곳 까지 (8)
        // until은 마지막을 포함 하지 않는다
        // 0 부터 8까지 이다
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (7)
    for (i in 0 until a.size step (2)) { //두단계씩
        println(a.get(i)) //0,2,4,6,8 번째 값 -> 1,3,5,7,9
    }
    println()

    // 반복하는 방법 (8)
    for (i in a.size - 1 downTo (0)) { // 높은 인덱스에서 낮은인덱스 순으로
        // 8 부터 0 까지 반복
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (9)
    for (i in a.size - 1 downTo (0) step (2)) {
        println(a.get(i)) //8,6,4,2,0 -> 9,7,5,3,1
    }
    println()

    // 반복하는 방법 (10)
    for (i in 0..a.size) { //0~9까지
        // .. -> 마지막을 포함한다
        println(i)
    }
    println()

    // 반복하는 방법 (11)
    var b: Int = 0 // -> 1 -> 2 -> 3 -> 4
    var c: Int = 4

    while (b < c) {
        b++ // while문을 정지 시키시키기 위한 코드
        println("b")
    }


    var d: Int = 0
    var e: Int = 4
    println()

    // 반복하는 방법 (12)
    do {
        println("hello")
        d++
    } while (d < e)


}