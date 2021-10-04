package com.example.myapplication.Kotlin

// 16. 반복문

fun main(array: Array<String>) {
    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법(1)
    for (item in a) {
        println(item)
        if (item == 5) {
            println("item is Five")
        } else {
            println("item in not Five")
        }
    }
    println()

    // 반복하는 방법(2)
    for ((index, item) in a.withIndex()) {
        println("index : $index  value : $item ")
        // 문자열 + Int(정수) = 문자열
        // 문자열 + 아무거나 = 문자열
    }
    println()

    // 반복하는 방법(3)
    a.forEach {
        println(it)
    }

    // 반복하는 방법(4)
    println()
    a.forEach { item ->
        println(item)
    }

    // 반복하는 방법(5)
    println()
    a.forEachIndexed() { index, item ->
        println("index : " + index + " value : " + item)
    }

    // 반복하는 방법(6)
    println()
    println(a.size)
    println()
    for (i in 0 until a.size) {
        // until은 마지막을 포함하지 않는다
        // 0부터 8까지 반복
        println(a.get(i))
    }
    println()

    // 반복하는 방법(7)
    for (i in 0 until a.size step (2)) {
        println(a.get(i))
    }

    // 반복하는 방법(8)
    println()
    for (i in a.size - 1 downTo (0)) {
        // 8부터 0까지 반복
        println(a.get(i))
    }

    // 반복하는 방법(9)
    println()
    for (i in a.size - 1 downTo (0) step (2)) {
        println(a.get(i))
    }

    // 반복하는 방법(10)
    // ..은 마지막을 포함한다
    println()
    for (i in 0 .. a.size) {
        println(i)
    }

    // 반복하는 방법(11)
    var b: Int = 0
    var c: Int = 4
    println()

    while (b < c) {
        b++ // while문을 정지시키기 위한 코드
        println("b")
    }
    println()
    println(b) // -> b가 4로 증가했다.

    // 반복하는 방법(12)
    println()
    var d: Int = 0
    var e: Int = 4
    do {
        d++
        println("hello")
    } while (d < e)

}