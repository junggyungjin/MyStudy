package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val operator: Operator = Operator()
    println(operator.divide(1, 2))
//    operator.plus(3,4).plus(4,5)
    //--------/operator
    //-----------------operator.plus(3,4) --> return 값 7을 받음
    //----------------------------7.plus(4,5) --> 잘못된 로직

    val calculator2 = Calculator2()
    println(calculator2.plus(1, 2, 3, 4))
    println(calculator2.minus(10, 1, 2, 3))
    println(calculator2.multiply(1, 2, 3))
    println(calculator2.divide(20,2,5))

    val calculator3 = Calculator3(3)
    calculator3.plus(5).minus(5)
    //----------/ -> calculator3(3)
    //--------------------/calculator3(3).plus(5) --> return값으로 calculator3(8)을 받음
    //-----------------------------------------/calculator3(8).minus(5) --> 올바른 로직
    // --> 자기 자신 클래스를 리턴하는 것을 Chaining(체이팅) 이라고 한다.
}

class Operator() {
    fun plus(first: Int, second: Int): Int {
        return first + second
    }

    fun minus(first: Int, second: Int): Int {
        // 첫 번째 수에서 두 번째 수를 뺀다
        return first - second
    }

    fun multiply(first: Int, second: Int): Int {
        return first * second
    }

    fun divide(first: Int, second: Int): Int {
        return first / second
    }
}

class Calculator2() {
    fun plus(vararg numbers: Int): Int {
        var result: Int = 0
        numbers.forEach {
            result = result + it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        for (i in 0 until numbers.size) {
            if (i != 0) {
                result = result - numbers[i]
            }
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result: Int = 1
        numbers.forEach {
            if (it != 0) {
                result = result * it
            }
        }
        return result
    }

    fun divide(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if (index != 0) {
                if (value != 0) {
                    result = result / value
                }
            }
        }
        return result
    }
}

class Calculator3(val initialValue: Int) {

    fun plus(number: Int): Calculator3 {
        val result = this.initialValue + number
        return Calculator3(result)
    }

    fun minus(number: Int): Calculator3 {
        val result = this.initialValue - number
        return Calculator3(result)
    }

    fun multiply(number: Int): Calculator3 {
        val result = this.initialValue * number
        return Calculator3(result)
    }

    fun divide(number: Int): Calculator3 {
        val result = this.initialValue / number
        return Calculator3(result)
    }
}

