package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val value: Int? = null
    when (value) {
        null -> println("value is null")
        else -> println("value is not null")
    }

    val value2: Boolean? = null

    // when 구문은 조건으로 갖는 값에 모든 경우에 대응해주는 것이 좋다
    when (value2) {
        true -> println("value2 is true")
        false -> println("value2 is false")
        null -> println("value2 is null")
    }

    // 값을 리턴하는 when 구문일 경우 반드시 값을 리턴해야한다
    val value3 = when (value2) {
        true -> 1
        false -> 3
        else -> 4
    }
    println(value3)

    // when의 다양한 조건식
    val value4: Int = 10
    when (value4) {
        is Int -> {
            println("value4 is int")
        }
        else -> {
            println("value4 is not int")
        }
    }

    // when의 다양한 조건식(2)
    val value5: Int = 70
    when (value5) {
        //value5가 60과 70사이의 값이라면
        in 60..70 -> {
            println("value is in 60-70")
        }
        in 70..80 -> {
            println("value is in 70-80")
        }
        in 80..90 -> {
            println("value is in 80-90")
        }
    }
}