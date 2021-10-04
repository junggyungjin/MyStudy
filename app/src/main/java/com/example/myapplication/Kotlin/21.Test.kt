package com.example.myapplication.Kotlin

fun main(args: Array<String>){
    val tv = TV(listOf<String>("K","M","S"))

    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())

    // cuurentChannelNumber가 불려나갈 때 -> get이 사용됨
//    tv.cuurentChannelNumber

}

class TV(val channels: List<String>){

    var onOrOff : Boolean = false // True -> On, False -> Off
    var cuurentChannelNumber = 0
        set(value) {
            // set을 사용하려면 변수명 밑에 적어야 함
//            cuurentChannelNumber = value --> 이렇게 쓰면 무한루프에 빠짐 -> set함수를쓴다 -> 값을할당한다 -> 값을할당하면 또 set함수를 호출 -> 또 값을할당 -> .....
            field = value // --> 이런 무한반복을 피할 수 있는 키워드가 바로 field
            // K -> M -> S -> K -> M -> S -> ... 이런 구조를 완성하기 위해 field가 2보다 커지면 다시 0으로 바꿔주는것
            if(field > 2){
                field = 0
            }
            // field가 0보다 작아지면 다시 2로 바꿔주는 것. 채널다운을 했을때 K -> S로 가기 위함
            if(field < 0){
                field = 2
            }
        }
    // set이라는 함수는 cuurentChannelNumber의 어떤 값을 할당할 때 사용된다
    // 값의 할당 : a = b
        get() {
            println("호출되었습니다")
            return field
        }
    // get은 cuurentChannelNumber가 호출될때 사용

    fun switch() {
        onOrOff = !onOrOff
    }

    fun checkCurrentChannel(): String {
        return channels[cuurentChannelNumber]
    }

    fun channelUp() {
        cuurentChannelNumber = cuurentChannelNumber + 1
//        channels.forEachIndexed { index, value ->
//            if(cuurentChannelNumber == index){
//                cuurentChannelNumber = cuurentChannelNumber+1
//                return
//            }
//        }
    }

    fun channelDown() {
        cuurentChannelNumber = cuurentChannelNumber - 1
//        channels.forEachIndexed{ index, value ->
//            if(cuurentChannelNumber == index){
//                cuurentChannelNumber = cuurentChannelNumber-1
//                return
//            }
//        }
    }
}