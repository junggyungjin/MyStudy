package com.example.myapplication.Kotlin

// 14. Collection
// -> list, set, map

fun main(args: Array<String>){

    // Immutable Collctions (처음 만들면 변경할수없는 콜렉션)
    // List --> 중복을 허용한다
    val numberList = listOf<Int>(1,2,4,3,3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    // Set --> 중복을 허용하지 않는다
    // --> 순서가 없다
    val numberSet = setOf<Int>(1,2,4,3,3)
    println()
    println(numberSet)
    numberSet.forEach() {
        println(it)
    }

    // Map --> Key,value 방식으로 관리한다
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println()
    println(numberMap)
    println(numberMap.get("one"))

    // Mutable Collection(변경가능)
    val mNumberList = mutableListOf<Int>(1,2,3)
    mNumberList.add(3,4)
    mNumberList.set(0,5)
    println()
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1,2,3,4,4,4)
    mNumberSet.add(10)
    println()
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println()
    println(mNumberMap)
    mNumberMap.set("one", 3)
    println()
    println(mNumberMap)
}
