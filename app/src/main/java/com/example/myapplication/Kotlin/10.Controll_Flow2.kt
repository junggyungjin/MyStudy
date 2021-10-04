package com.example.myapplication.Kotlin

//10. 제어흐름

// When

fun main(args: Array<String>) {
    val value: Int = 3

    // when(조건)
    when (value) {
        // value가 1일때 실행한다
        // when도 중괄호를 넣어도 되고 안넣어도 됨
        1 -> println("value is 1")
        2 -> println("value is 2")
        3 -> println("value is 3")
        else -> println("I do not know value")
    }
    // if도 중괄호를 안넣고 사용할 수 있음
    if (value == 1) println("value is 1")
    else if (value == 2) println("value is 2")
    else if (value == 3) println("value is 3")
    else println("I do not know value")

    // when도 값을 return 가능함
    val value2 = when(value){
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 100
    }
    println()
    println(value2)

}

