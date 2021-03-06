package com.example.myapplication.Kotlin

// 12. 배열

/**
 * 배열이 필요한 이유
 * 그룹이 필요할 때
 */

fun main(array: Array<String>) {

    // 배열을 생성하는 방법(1)
    var group1 = arrayOf<Int>(1, 2, 3, 4, 5)
    println(group1 is Array)

    // 배열을 생성하는 방법(2)
    // 배열에 타입을 적어주지 않으면 아무 타입이나 다 배열에 넣을 수 있음
    var group2 = arrayOf(6, 7, 8, 9, "Hello")

    // 배열의 값을 꺼내는 방법(1)
    val test1 = group1.get(0)
    val test2 = group1.get(4)
    val test3 = group1.get(3)
    println()
    println(test1 + test3)
    println(test2)

    // 배열의 값을 꺼내는 방법(2)
    println()
    val test4 = group1[1]
    val test5 = group1[2]
    println(test4)
    println(test5)

    // 배열의 값을 바꾸는 방법(1)
    group1.set(0, 100)
    println(group1[0])

    // 배열의 값을 바꾸는 방법(2)
    group1[0] = 200
    println(group1[0])


}