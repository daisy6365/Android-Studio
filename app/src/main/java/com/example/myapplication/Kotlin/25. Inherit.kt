package com.example.myapplication.Kotlin


// 두번까지는 봐준다
// 두번 이상이 넘어가면 리펙토링 해라 -> 정리정돈후에도 기능이 정상작동 해야함

// 25. 상속
// 부모로부터 설명서를 물려받는다!
// 반복을 피함
// 모든 차에는 종류가 다르지만 기능들은 다 비슷함 -> 불편한 중복을 피하기 위해 상속을 사용
// 기능포함 변수들도 상속받

fun main(args: Array<String>) {
    val car100 : Car100 = Car100()
    println(car100.drive())
    val superCar100: SuperCar100 = SuperCar100()
    println(superCar100.drive())
//    superCar100.stop()
//
    val bus100: Bus100 = Bus100()
    println(bus100.drive())
}

// 부모 : Car100
// 자식 : SuperCar100, Bus100
// class 앞에 private 사용하면 상속하여 활용 XX -> open 사용
open class Car100() {
    // 접근하여 수정할 수 있도록 open 사용
    open fun drive(): String {
        return "달린다"
    }

    fun stop() {

    }
}

// Car100 상속받음
class SuperCar100() : Car100() {
    // 기본 Car100의 drive 보다 조금더 빠르게
    // 기능 유사 -> 추가 수정
    // 맨앞에 override 작성 (덮어썼다는 의미)
    override fun drive(): String {
        val run = super.drive()// super -> 부모 라는 의미 => 부모의 drive 기능에 접근
        return "빨리 $run"
    }
}

// Car100 상속받음
class Bus100() : Car100() {
    override fun drive(): String {
        val run1 = super.drive()
        return "안전하게 $run1"
    }
}
