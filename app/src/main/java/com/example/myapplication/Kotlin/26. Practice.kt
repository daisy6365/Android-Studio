package com.example.myapplication.Kotlin

// 26. 과제
// Night, Monster (부모 클래스)
// SuperNight, SuperMonster (자식 클래스)
// 24. Practice 이용하여 클래스 만들고 상속을 이용하여 업그레이드된 자식 클래스 생

fun main (array : Array<String>) {

    val supernight = SuperNight(1000, 50)
    val supermonster = SuperMonster(1000,60)
    supernight.attack(supermonster)
    supermonster.attack(supernight)
    supernight.shot(supermonster)
    supermonster.bite(supernight)
}


open class Night1(private var hp: Int, var power: Int){
    fun attack(monster1: Monster1,power: Int = this.power){
        monster1.defense(power)
    }
    fun defense(damage: Int){
        if(hp > 0) {
            hp -= damage
            heal()
            println("night's hp is $hp")
        }
        else println("night dead!")

    }
    fun heal(){
        hp += 3

    }
}
open class Monster1(private var hp: Int, var power: Int){
    fun attack(night1: Night1, power: Int = this.power){
        night1.defense(power)
    }
    fun defense(damage: Int){
        if(hp > 0) {
            hp -= damage
            println("monster's hp is $hp")
        }
        else println("monster dead!")
    }
}

class SuperNight(hp: Int, power: Int) : Night1(hp, power) {
    fun shot(monster1: Monster1){
        super.attack(monster1, power+10)
    }

}

class SuperMonster(hp: Int, power: Int) : Monster1(hp, power) {
    fun bite(night1: Night1){
        super.attack(night1,power+10)
    }
}
