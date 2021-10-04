package com.example.myapplication.Kotlin

// 27. Interface
/**
 * - 인터페이스는 약속! -> 니가 이것을 구현하고 너도 이 타입이다!
 * - 생성자가 없다 -> 인스턴스화 시킬 수 없다 -> 인스턴스화 시킬 수 없다 -> 설명서가 아니다
 * - 지침서 -> 니가 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라!
 * 인터페이스는 부모 인터페이스의 기능이 자식클래스들에게 있는데 그 기능이 많이 다를때 편하다
 */

/**
 * 상속은 자식클래스들에게 공통으로 가지고 있는 기능을 부모 클래스들에게 올려놓으면 편하다
 * 또 부모클래스의 기능을 자식클래스들이 쓰는데 그 기능이 조금 다를때 상속이 편하다
 */

/**
 * 상속과 다른 점
 * - 상속은 조상을 찾아가는 느낌
 * - 인터페이스는 종의 특징
 */

fun main(args: Array<String>) {
    val student_ : Student_ = Student_()
    student_.eat()
    student_.sleep()
}

interface Person_ {
    fun eat()
    fun sleep()
}

class Student_ : Person_ {
    override fun eat() {

    }

    override fun sleep() {

    }
}

class SoccerPlay : Person_ {
    override fun eat() {

    }

    override fun sleep() {

    }
}


open class Person() {
    open fun eat() {

    }

    fun sleep() {

    }
}

class Student() : Person() {
    override fun eat() {
        super.eat()
    }
}

class Teacher() : Person() {

}