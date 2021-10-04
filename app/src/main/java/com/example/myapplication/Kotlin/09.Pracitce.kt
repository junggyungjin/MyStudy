package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

    val a: Int? = null
    val b: Int = 10
    val c: Int = 100

    if (a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }

    if (b + c == 110) {
        println("b plus c is 110")
    } else {
        println("b plus c is not 110")
    }

    // 엘비스 연산자 --> 코틀린 언어에서만 있는 특징(null-safe한 언어)
    val number: Int? = null
    val number2 = number ?: 10 // number가 null이면 number2에 10을 넣는다
    println()
    println(number2)

    val nl: String? = null
    val nl2 = nl ?: "not null"
    println()
    println(nl2)

    val num1: Int = 10
    val num2: Int = 20

    //값을 리턴하는 else if문을 사용할때는 반드시 값을 리턴해야 한다!
    val max = if (num1 > num2) {
        num1
    } else if (num1 == num2) {
        num2
    } else {
        100
    }

}
