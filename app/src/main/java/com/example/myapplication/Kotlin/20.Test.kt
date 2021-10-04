package com.example.myapplication.Kotlin

fun main(array: Array<String>){
    val tAccount : TAccount = TAccount("홍길동","1994/05/02",1000)
    println(tAccount.checkBalance())
    println(tAccount.save(1000))
    println(tAccount.withdraw(2000))
    println(tAccount.checkBalance())

    println()
    val account2 = Account2("홍서방", "1990/3/5")
    val account3 = Account2("홍서방", "1990/3/5",4000)
    println(account2.checkBalance())
    println(account3.checkBalance())

}

class Account {
    var money: Int = 100000000
    var name: String = ""
    var info: Int = 0
    var pass: Int = 0


    constructor(name: String, info: Int) {
        this.name = name
        this.info = info
    }

    constructor(name: String, info: Int, money: Int) {
        this.name = name
        this.info = info
        this.money = money
    }

    constructor(pass: Int, money: Int) {
        this.pass = pass
        this.money = money
    }

    fun Make(name: String, info: Int) {
        if (name.equals(this.name) && info.equals(this.info)) {
            println("계좌 생성 완료")
        } else {
            println("계좌 생성 실패")
        }

    }

    fun checkMoney(name: String, info: Int) {
        if (name.equals(this.name) && info.equals(this.info)) {
            println("조회된 금액은 $money 입니다")
        } else {
            println("금액을 조회할 수 없습니다")
        }
    }

    fun getMoney(pass: Int, getmoney: Int): Int {
        println("$getmoney 를 출금하셨습니다.")
        var mm = (this.money - getmoney)
        return mm
    }

    fun saveMoney(pass: Int, savemoney: Int) {

    }
} // -> 내가 만든 계좌

// TAccount(val name: String, val birth: String, var balance: Int)
// TAccount의 문제 : 계좌를 생성할때 초기 금액을 음수로 넣을 수가 있다.
class TAccount {

    val name: String
    val birth: String
    var balance: Int

    constructor(name: String, birth: String, balance: Int){
        this.name=name
        this.birth=birth
        // 초기금액을 넣을때 음수는 못 넣게 검사.
        if(balance>=0){
            this.balance=balance
        }else {
            this.balance=0
        }

    }

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if ( balance >= amount){
            balance = balance - amount
            return true
        }else {
            return false
        }
    }

    fun save(amount: Int) {
        balance += amount
    }
}

// 은행에서 이벤트 -> 계좌를 만들때 무조건 천원을 입금해주는 이벤트
class Account2(val name: String, val birth: String, var balance: Int = 1000){
    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int): Boolean {
        if ( balance >= amount){
            balance = balance - amount
            return true
        }else {
            return false
        }
    }

    fun save(amount: Int) {
        balance += amount
    }
}

// 계좌 생성할때 초기 금액으로 음수는 못들어가게 하는 또 다른 방법
// 밸류나 배리어블을 선언하지 않은 변수를 생성자에 사용하는 방법.
class Account3(initialBalance: Int){
    //값을 리턴하는 if문
    val balance : Int = if (initialBalance >=0) initialBalance else 0

    fun checkBalace(): Int {
        return balance
    }
}