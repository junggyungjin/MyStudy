package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    lateinit var lateCar : Car

    class Car(var number : Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

//        lateCar를 쓰기전에 먼저 초기화해줘야 한다
//        lateCar = Car(10)
//        Log.d("number", "late number : "+ lateCar.number)
//
//        val number: Int = 10
        val number1: Int? = 5
//
//        // !! -> 개발자가 null이 아님을 보장
        val number5 : Int = number1!! + 10
        Log.d("number","number5 : $number5")
//
////        val number3 = number1? + number
//        val number3 = number1?.plus(number)
////        Log.d("number", "number3 + " + number3)
//
//        // 삼항연산자 -> 앨비스 연산자
//        // Null safety 를 위한 도구
//        val number4 = number1 ?: 10 // 넘버1이 널이면 10이 넘버4에 들어가고 넘버1이 널이 아니라면 넘버1이 넘버4에 들어간다
////        Log.d("number", "number4 : "+number4)

    }

    // null이 될 수 없는 리턴타입을 가진 메소드
    fun plus(a: Int, b: Int?): Int {
        if (b != null) return a + b
        else return a
    }

    // null이 될 수 있는 리턴타입을 가진 메소드
    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}