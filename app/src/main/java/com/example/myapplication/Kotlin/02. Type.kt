package com.example.myapplication.Kotlin

// 02. 자료형
// 정수형 -> Long > Int > Short > Byte
// 실수형 -> Double > Float
// 문자형 -> Char
// 문자열형 -> String
// 논리형(참(True)/거짓(False)) -> Boolean
//변수선언(1)
var number = 10

//변수선언(2)
//자료형을 선언함
var number1 : Int = 20
var hello1 : String = "Hello"
var point1 : Double = 3.4

//Variable or value ??
// -1. 변하지 않는 값이라면 -> val
// -2. 변할지 안변할지 모르겠다 -> val 한후 변할시에 var로 변경

fun main (args:Array<String>) {
    number = 20
    //number = 20.5 // error 발생


}
