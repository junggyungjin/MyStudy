package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
//    first()
//    second(75)
//    println(third(11))
    gogodan()
}

fun first() {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Boolean>()
//    MutableList(9,{0})
//    MutableList(9,{true})

    for (i in 0..9) {
        list1.add(i)
//        listi = [i]
    }
    println(list1)

    for (i in 0 until list1.size) {
        if (list1[i] % 2 == 0) {
            list2.add(true)
        } else if (list1[i] % 2 == 1) {
            list2.add(false)
        } else {
            println("Zero")
        }
    }
    println(list2)
    println()

//    list1.forEachIndexed { index, value ->
//        if (value % 2 ==0){
//            list2[index] = true
//        }else {
//            list2[index] = false
//        }
//    }
}

fun second(score: Int) {
    when (score) {
        in 80..100 -> println("A")
        in 70..79 -> println("B")
        in 60..69 -> println("C")
        else -> println("F")
    }
}
//fun second(score: Int): String{
//    when(score){
//        in 80 .. 100 -> return "A"
//        in 70 .. 79 -> return "B"
//        in 60 .. 69 -> return "C"
//        else -> return "F"
//    }
//}

fun third(input: Int): Int{
    var result: Int = input/10
    var result2: Int = input%10
    return result+result2
}

fun gogodan() {
    for (i in 1..9) {
        for (j in 1..9) {
            println("$i X $j = ${i*j}")
        }
    }
}

