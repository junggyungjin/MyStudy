package com.example.myapplication.Kotlin


var a = 1+2+3+4+5 // 연산의 결과값을 변수에 넣어줄수있다
var b = "1"
var c = b.toInt()
var d = c.toFloat()

var e = "John"
var f = "My name is $e Nice to meet you"

/**
 * Null : 존재하지않는다
 */

//var abc : Int = null --> 오류
// 데이터타입 뒤에 ?가 붙으면 변수를 null로 선언 가능
var abc1: Int? = null
var abc2: Double? = null

var g = a + 3

fun main(args:Array<String>){
    println(a)
    println(b)
    println(c)
    println(d)
    println(f)
    println(abc1)

    println(g)

}