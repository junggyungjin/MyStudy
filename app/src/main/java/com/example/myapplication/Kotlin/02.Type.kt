package com.example.myapplication.Kotlin

/**
 * 02. 자료형
 * 정수형 -> Long -> Int -> Short -> Byte
 * 실수형 -> Double -> Float
 * 문자 -> Char
 * 문자열 -> String
 * 논리형 -> Boolean
 */
var number = 10

/**
 * 변수선언하는방법(2)
 * var/val 변수 : 자료형 = 값
 */
var number1: Int = 20
var hello1: String = "Hello"
var point1: Double = 3.4

/**
 * Variable or Value ??
 * - 1. 변하지 않는 값이라면 -> Value
 * - 2. 진짜 모르겠다! -> Value
 */

fun main(args: Array<String>) {
    number = 20
    System.out.println(number)
}