package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val night = Night(20, 4)
    val monster = Monster(15, 5)

    night.attack(monster)
    monster.attack(night)


}

open class Night(private var hp: Int, private var power: Int) {

    fun attack(monster: Monster) {
        monster.defense(power)
    }

    fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) {
            heal()
            println("기사의 현재 체력은 $hp 입니다")
        } else println("기사가 죽었습니다")
    }

    private fun heal() {
        // 아무때나 사용하는게 아니라
        // 공격을 당했을때 죽지 않았다면 힐을 한다 --> 프라이빗을 쓴다
        hp += 3
    }
}

// 어떤 클래스를 만들 때 일단 프라이빗을 써서 외부에서 접근이 불가능하게하고
// val를 써서 변경이 안되게 만들고보자
// 나중에가서 변경할일이 있으면 var로 바꾸자
class Monster2(private val hp: Int, private val power: Int) {
    //함수를 만들때도 일단 프라이빗으로 만들자! 그리고 나중에 바꾸자
}

open class Monster(private var hp: Int, private var power: Int) {
    fun attack(night: Night) {
        night.defense(power)
    }

    fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("몬스터 현재 체력은 $hp 입니다")
        else println("몬스터가 죽었습니다")
    }
}