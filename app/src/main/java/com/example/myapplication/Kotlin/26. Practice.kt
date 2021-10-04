package com.example.myapplication.Kotlin

// 과제
// Night, Monster (부모) -> Charactor
// Supernight, SuperMonster(자식)

fun main(array: Array<String>) {
    val monster = SuperMonster(100, 10)
    val night = Supernight(130, 8)
    monster.attack(night)
    monster.bite(night)

}

// 상속이 만들어낸 특징
// 자식클래스는 부모 클래스의 타입이다 즉 슈퍼나이트도 캐릭터고 슈퍼몬스터도 캐릭터다
// 부모클래스는 자식클래스의 타입이 아니다 즉 반대로는 성립이 안된다

open class Charator(var hp: Int, val power: Int) {

    fun attack(charator: Charator, power: Int = this.power) {
        charator.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("${javaClass.simpleName}의 남은 체력 $hp 입니다")
        else println("사망했습니다")
    }

}

// 자식 클래스가 인스턴스화 되기 위해서는 부모클래스가 선행되서 인스턴스화 되어야 한다
class Supernight(hp: Int, power: Int) : Charator(hp, power) {

    val defensePower = 2

    override fun defense(damage: Int) {
        super.defense(damage - defensePower)
    }
}

class SuperMonster(hp: Int, power: Int) : Charator(hp, power) {

    fun bite(charator: Charator) {
        super.attack(charator, power + 2)
    }
}