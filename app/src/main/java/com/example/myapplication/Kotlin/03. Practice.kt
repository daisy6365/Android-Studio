package com.example.myapplication.Kotlin

//Variable & Type 실습

var a = 1+2+3+4+5 //연산의 결과값을 변수에 넣어줄 수 있음
var b = "1"
var c = b.toInt() //문자열 1을 정수값으로 바꿔줌
var d = b.toFloat()

var e = "John"
var f = "My name is $e. Nice to meet you"

//Null
// - 존재하지 않음
//var abc : Int = null  //error -> Int형은 null을 받을수 있는 형태가 아님
var abc1 : Int? = null //error XX -> null을 가질수 있음
var abc2 : Double? = null

var g = a + 3 //13

fun main(array:Array<String>){
    println(a)
    println(b)
    println(c)
    println(d)
    println(f)
    println(abc1)
    println(abc2)
    println(g)
}

