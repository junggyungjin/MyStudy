package com.example.myapplication.Kotlin

// 두번까지는 봐준다
// 세 번 이상이 넘어가면 리팩토링 해라

// 25. 상속
// 부모로부터 설명서를 물려받는다!

fun main(args: Array<String>) {
    var superCar100 : SuperCar100 = SuperCar100()
    println(superCar100.drive())
//    superCar100.stop()
//
//    val bus100 = Bus100()
//    bus100.drive()


}

//클래스를 선언할 때는 앞에 기본적으로 프라이빗이 선언되어있음
//외부에서 접근할 수 있게 하는 키워드 -> open
open class Car100(){
    open fun drive(): String {
        return "달린다"
//        println("달린다")
    }

    fun stop() {

    }
}

class SuperCar100() : Car100() {
    override fun drive(): String {
        val run = super.drive()
        return "빨리 $run"
    }
}

class Bus100() : Car100() {

}