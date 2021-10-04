package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val array = arrayOf<Int>(1, 2, 3)

    // get, set
    val number = array.get(0)
    println(number)
    array.set(0, 100) // array[0] = 100 과 똑같음
    val number2 = array.get(0) // array[0]과 똑같음
    println(number2)

    /**
     * array.set(100, 100) --> 오류
     * Array의 Bounds
     * - 처음 만들때 결정 된다
     */

    // Array를 만드는 방법(3)
    val a1 = intArrayOf(1, 2, 3)
    val a2 = charArrayOf('b', 'b')
    val a3 = doubleArrayOf(1.1, 100.345)
    val a4 = booleanArrayOf(true, false, true)

    // Array를 만드는 방법(4) -> lambda를 활용한 방법
    var a5 = Array(10, { 0 })
    var a6 = Array(5, { 1;2;3;4;5; })

    for ((index,item) in a5.withIndex()) {
        println("index : $index item : $item ")
    }

}