package com.example.myapplication.Kotlin

// 14. Collection
//  -> list, set, map -> 값 변결할수 없음 (val)


fun main(args: Array<String>) {

    // Immutable Collections (변경 불가능)
    // List -> 중복을 허용한다
    val numberList = listOf<Int>(1, 2, 3, 3)
    println(numberList)
    println(numberList.get(0)) //1
    println(numberList[0]) //1


    // Set
    //  -> 중복을 허용하지 않는다 -> [1, 2, 3]
    //  -> 순서가 없다!!! -> index 없음 .get 허용X
    val numberSet = setOf<Int>(1, 2, 3, 3, 3)
    println()
    numberSet.forEach {
        println(it)
    }

    // Map -> Key,value 방식으로 관리한다
    // one -> key , 1 -> value
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println()
    println(numberMap.get("one"))


    // Mutable Collection (변경가능)
    val mNumberList = mutableListOf<Int>(1, 2, 3)
    mNumberList.add(3, 4) //[1,2,3,4]
    println()
    println(mNumberList)


    val mNumberSet = mutableSetOf<Int>(1, 2, 3, 4, 4, 4)
    mNumberSet.add(10) //[1,2,3,4,10]
    println(mNumberSet)


    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2) //[1,2]
    println(mNumberMap)

}

