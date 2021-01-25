package com.example.myapplication.Kotlin

//인자 이름 -> array 타입 -> Array(배열)
fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3)
    a.add(4) //[1,2,3,4]
    println(a)
    a.add(0, 100) //[100, 1, 2, 3, 4]
    println(a)
    a.set(0, 200) //[200, 1, 2, 3, 4] //값을 바꿈
    println(a)
    a.removeAt(1)//[200, 2, 3, 4]
    println(a)


    val b = mutableSetOf<Int>(1, 2, 3, 4)
    println()
    b.add(2)//중복 허용X
    println(b)
    b.remove(2) //[1, 3, 4]
    println(b)
    b.remove(100)//[1, 3, 4]-> 에러발생X
    println(b)


    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two", 2)//{one = 1, two =2}
    println(c)
    c.replace("two", 3)//{one = 1, two =3}
    println(c)
    println(c.keys)//{one, two}
    println(c.values)//{1,3}
    c.clear()//삭제
    println(c)


}