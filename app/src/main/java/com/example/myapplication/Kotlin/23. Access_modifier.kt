package com.example.myapplication.Kotlin



/// 23. 접근 제어자


fun main(array: Array<String>) {

    //class 생성
    val testAccess: TestAccess = TestAccess("아무개")

    // Pirvate  키워드 때문에 외부에서 더 이상 사용할수 없다.
    // 접근이 너무 쉬워짐
//    testAccess.test()
//    println(testAccess.name)
//    testAccess.name = "아무개 투"
//    println(testAccess.name)

    val reward: Reward = Reward()
    reward.rewardAmount = 2000


    val runningCar: RunningCar = RunningCar()
    runningCar.runFast()
//    runningCar.run()


}

class Reward() {
    var rewardAmount: Int = 1000
}

//clss 설명서
class TestAccess {

    //접근이 가능하지 못하도록 private 써줌
    private var name: String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun changeName(newName: String) {
        this.name = newName
    }

    private fun test() {
        println("테스트")
    }
}


class RunningCar() {


    fun runFast() {
        run()
    }

    //또 다른 함수를 메인 함수에 공개하고 싶지 않을때 private 사용
    private fun run() {

    }


}