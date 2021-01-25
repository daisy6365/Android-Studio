package com.example.myapplication.Kotlin

import android.media.tv.TvRecordingClient

// 19. 중간과제
// # 1 문제
// 사칙연산을 수행할 수 있는 class

// # 2 문제
// 은행 계좌 class
// - 계좌 생성 기능 (이름, 생년 월일)
// - 잔고 확인 기능
// - 출금 기능
// - 예금 기능

// # 3 문제
// TV class
// - on/off 기능
// - 채널 돌리는 기능
// - 초기 채널은 (SBS, MBC, KBS)

fun main (array : Array<String>) {
    val operator : Operator = Operator(50,10)
    operator.plus()
    operator.minus()
    operator.multiply()
    operator.division()


    val account: Account = Account("한다빈", "1998/8/19", 50000)
    account.check()
    account.out(15000)
    account.check()
    account.enter(20000)
    account.check()

    val tv = TV(listOf<String>("KBS", "MBC", "SBS"))
    tv.work()
    tv.turnUp()
    tv.turnUp()
    tv.turnUp()
    tv.turnDown()
    tv.turnDown()
    tv.work()


}

class Operator constructor(var n: Int, var m : Int){
    fun plus(){
        println("$n + $m = ${n+m}") //60
    }
    fun minus(){
        println("$n - $m = ${n-m}") //40
    }
    fun multiply(){
        println("$n * $m = ${n*m}") //500
    }
    fun division(){
        println("$n / $m = ${n/m}") //5
    }
}
/*class Calculator2() {
    fun plus(vararg numbers: Int): Int { //1,2,3,
        var result: Int = 0
        numbers.forEach {
            result = result + it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {//10, 1, 2, 3
        // 10 - 1 - 2 - 3
        // 0 - 10 - 1 -2 -3
        var result: Int = numbers[0]
        for (i in 0 until numbers.size) {
            if (i != 0) {
                result = result - numbers[i]
            }
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result: Int = 1
        numbers.forEach {
            if (it != 0) {
                result = result * it
            }
        }
        return result
    }

    fun divide(vararg numbers: Int): Int {// 10, 2, 3 -> 10/2/3
        var result: Int = numbers[0] //10
        numbers.forEachIndexed { index, value ->
            //10 -> 10/10/2/3
            if (index != 0) {
                if (value != 0) {
                    result = result / value
                }
            }
        }
        return result
    }

}*/

class Account {
    val name : String
    val birth : String
    var money : Int

    constructor(name:String, birth:String, money:Int){
        this.name = name
        this.birth = birth
        if(money >= 0) this.money= money else this.money = 0
    }

    fun check(){
        println("$money")
    }
    fun out(out : Int): Boolean{
        if(money >= out)  {
            money = money - out
            return true
        }
        else return false
    }
    fun enter(enter : Int){
        money += enter
    }
}

class TV constructor(val channels: List<String>){
    var onOroff : Boolean = false
    var currentChannel = 0 //현재의 채널 0-> KBS 채널 돌아갈때마다 반복
    // channels의 인덱스보다 크면 다시 처음으로 돌아가게함
    set(value) {
        field = value //무한루프를 피하는 코드
        if(field > 2) field = 0
        else if (field < 0) field = 2
        //currentChannel = value 로 설정하면 무한루프에 빠짐
        //-> 값을 할당하면 set함수가 호출되므로 할당->호출 루프가 시작됨
    }


    fun work(){
        onOroff = !onOroff
        println("$onOroff")
    }

    fun turnUp(){
        currentChannel++
        println("${channels[currentChannel]}")

        //불필요한 반복문은 코딩테스트에서 감점요인 !!!!
//        channels.forEachIndexed{index, value ->
//            if(currentChannel == index) {
//                currentChannel++
//                println("${channels[currentChannel]}")
//                return // 채널을 돌려주고 나감
//            }
//        }

    }
    fun turnDown(){
        currentChannel--
        println("${channels[currentChannel]}")
//        channels.forEachIndexed{index,value ->
//            if(currentChannel == index){
//                currentChannel--
//                println("${channels[currentChannel]}")
//                return
//            }
//        }
    }
}