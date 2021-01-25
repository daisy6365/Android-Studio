package com.example.myapplication.Kotlin

// 27. Interface
// - 인터페이스는 약속 ! -> 니가 이것을 구현하면 너도 이 타입이다!
// - 생성자가 없다 -> 인스턴스화 시킬수 없다 -> 설명서가 아니다!
// - 지침서 -> 니가 이것을 구현하고 싶다면 받듯이 아래 기능을 구현해라!
// - 회사에서 협업할때 많이 사용 -> 인터페이스 구현시켜서 반드시 필요한 기능을 각자 만듦

// 상속이 만들어낸 특징
// - 자식 클래스는 부모 클래스의 타입이다
// - 부모 클래스는 자식 클래의 타입이 아니다!

// 상속과 다른점
// - 상속은 조상을 찾아가는 느낌
// - 인터페이스는 종의 특징

fun main(args: Array<String>) {
    val student_: Student_ = Student_()

    //eat과 sleep기능이 반드시 있음
    student_.eat()
    student_.sleep()

    val soccerPlay: SoccerPlay = SoccerPlay()
    soccerPlay.eat()
    soccerPlay.sleep()


}

interface Person_ {
    fun eat()
    fun sleep()
}

// 인터페이스를 구현하면 반드시 eat과 sleep 기능들을 사용해야한
class Student_ : Person_ {
    override fun eat() {
        println("학생은 공부와 성장을 위해 많이 먹는다.")
    }

    override fun sleep() {
        println("학생은 성적과 성장을 위해 충분히 잔다")
    }
}

class SoccerPlay : Person_ {
    override fun eat() {
        println("축구선수는 운동을 위해 건강식을 먹는다")
    }

    override fun sleep() {
        println("축구선수는 운동을 위해 충분히 잔다")
    }
}


/*open class Person() {
    open fun eat() {

    }

    fun sleep() {

    }
}


class Student() : Person() {

}

class Teacher() : Person() {

}*/