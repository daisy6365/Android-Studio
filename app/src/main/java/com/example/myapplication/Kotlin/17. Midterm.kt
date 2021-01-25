package com.example.myapplication.Kotlin

// 17. 중간과제
// # 1 문제
// list를 2개 만듦
// list1에는 0 ~ 9까지 값을 넣음 (반복문으로) [1, 2, 3, 4, 5, 6, 7, 8, 9]
// list2에는 list1의 값을 확인한후 -> 짝수면 true 홀수면 false 출력 [false, true, ...]

// # 2 문제
// 학점 구하기
// 80 - 90 -> A
// 70 - 79 -> B
// 60 - 69 -> C
// 나머지 -> F

// # 3 문제
// 전달 받은 숫자의 각 자리 수의 합을 구하자
// 조건 : 전달 받은 숫자는 무조건 두자리 숫자이다.

// # 4 문제
// 구구단 출력
fun first(){
    var list1 = MutableList(10, {0})
    var list2 = MutableList(10, {true})
    var i = 0

    while (i < 10 ) {
        list1[i] = i+1
        i++
    }
    /*for (i in 0..8) {
        list1[i] = i + 1
    }*/
    println(list1)

    list1.forEachIndexed { index, item ->
        if(item % 2 == 0) list2[index] = true
        else list2[index] = false
    }
    println(list2)
}

fun second(a : Int){
    when (a){
        in 80..90 -> println("A")
        in 70..79 -> println("B")
        in 60..69 -> println("C")
        in 0..59 -> println("F")
    }
}

fun third(num: Int){
    val n = num / 10
    val m = num % 10

    println(n+m)
}

fun fourth(){
    for(item in 1..9) {
        for(it in 1..9) {
            var result = item * it
            println("$item * $it = $result")//println("$x x $y = ${x * y}")
        }
    }
}

fun main (array : Array<String>) {
    first()
    second(89)
    third(78)
    fourth()
}