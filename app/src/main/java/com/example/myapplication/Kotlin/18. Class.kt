package com.example.myapplication.Kotlin


// 18. Class

// OOP -> Object Oriented Programming (객체지향 프로그래밍)

// "객체"란 뭘까?
// - 이름이 있는 모든 것


// 절차지향 프로그래밍 문제 해결 방법
// - 코드를 위에서 부터 아래로 실행을 하면 문제가 해결된다!

// 객체지향 프로그래밍 문제 해결 방법
// - 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다
// - 호출하면 호출한곳으로 가서 실행
// - 선수, 심판, 경기장, 관중 -> 축구 게임

// 객체를 만드는 방법
// - 설명서가 있어야 합니다(객체를 담고 있는)

fun main(array: Array<String>) {
    // 클래스(설명서)를 통해서 실체를 만드는 방법
    // -> 인스턴스화 -> 인스턴스(객체)
    Car("v8 engine", "big")

    val bigCar = Car("v8 engine", "big")

    // 우리가 만든 클래스(설명서)는 자료형이 된다결
    // 함수들 호출
    val bigCar1: Car = Car("v8 engine", "big")
    val superCar: SuperCar = SuperCar("good engine", "big", "white")

    // 인스턴스가 가지고있는 기능을 사용하는 방법
    // RunnableCar.ride() -> XXX 에러 발생
    // (RunnableCar은 밑에서 선언한 설명서 일뿐 설명서 안에 기능 존재XX)
    val runableCar: RunableCar = RunableCar("simple engine", "short body")
    runableCar.ride()
    runableCar.navi("부산")//변수 필요하므로 넣어줌
    runableCar.drive()

    // 인스턴스의 멤버 변수에 접근 하는 방법
    val runableCar2: RunableCar2 = RunableCar2("nice engine", "long body")
    println(runableCar2.body)
    println(runableCar2.engine)
    runableCar2.ride()
    runableCar2.navi("인천")//변수 필요하므로 넣어줌
    runableCar2.drive()


    println()
    val testClass = TestClass()
    testClass.test(1) //up
    testClass.test(1, 2)// down


}

// 클래스(설명서) 만드는 방법(1)
class Car constructor(var engine: String, var body: String) {

}

// 클래스(설명서) 만드는 방법(2)
class SuperCar {
    //부품을 중괄호안에 넣어줌
    var engine: String //good engine
    var body: String //big
    var door: String //white

    //constructor안에 부품들의 자료형을 지정 -> 위에 선언한 변수와 연결
    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
        /*println(engine)
        println(body)
        println(door)*/
    }
}

// 클래스(설명서) 만드는 방법(3) -> 1번 방법의 확장
// 뒤에 constructor 에는 반드시 필요한 부분 작성
class Car1 constructor(engine: String, body: String) {
    //!!!추가적으로 필요!!!한 부품 door 작성
    var door: String = "" //기본값 넣어줌

    //생성자
    // 추가적으로 넣으면 좋은 것들
    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door//할당
    }
}

// 클래스(설명서) 만드는 방법(4) -> 2번 방법의 확장
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    //반드시 필요한 부분 contructor 뒤에 작성
    //내부에 constructor 지정
    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    //생성자 (3)의 아랫 부분 표
    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}


class RunableCar(engine: String, body: String) {

    //기능 추가
    fun ride() {
        println("탑승 하였습니다")
    }

    //기능 추가
    fun drive() {
        println("달립니다 !")
    }

    //기능 추가 (변수 받음)
    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다")
    }
}

class RunableCar2 {
    var engine: String
    var body: String

    //내부에 constructor 지
    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init {
        // 초기셋팅을 할 때 유용하다
        println("RunableCar2가 만들어 졌습니다")
    }

    fun ride() {
        println("탑승 하였습니다")
    }

    fun drive() {
        println("달립니다 !")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다")
    }
}


// !!오버로딩!!
// -> 이름이 같지만 받는 파라미터가 다른 함수
class TestClass() {

    //함수 이름 동일
    fun test(a: Int) {
        println("up")
    }

    //함수이름 동일 BUT, 파라미터가 다름 -> 구분이 가능
    fun test(a: Int, b: Int) {
        println("down")
    }
}