package com.example.myapplication.Kotlin

fun main(array: Array<String>){
    val testAccess : TestAccess = TestAccess("이무개")
//    private 키워드 때문에 외부에서 사용할 수 없다
//    testAccess.test()
//    println(testAccess.name)
//    testAccess.name = "아무개 투"
//    println(testAccess.name)

    // 보상을 천원만 주기로 설정을 했는데 2천원을 주게 바뀌어질수가있음
    val reward : Reward = Reward()
    reward.rewardAmount = 2000

    val runableCar : RunningCar = RunningCar()
    runableCar.runFast()
//    runableCar.run() --> 프라이빗으로 사용 못하게 막음, 같은 클래스인 runFast메소드 안에서 run을 사용하게 함
}

class Reward(){
    var rewardAmount: Int = 1000
}

class TestAccess{
    // 프라이빗은 클래스 외부에서 접근을 막음
    private var name: String = "홍길동"

    constructor(name: String){
        this.name = name
    }

    fun changName(newName: String){
        this.name = newName
    }

    // 메소드 앞에도 프라이빗을 붙일 수 있음
    private fun test(){
        println("테스트")
    }
}

class RunningCar(){

    fun runFast() {
        run()
    }

    private fun run() {
        // 외부기능을 보조하기 위한 기능.
    }
}