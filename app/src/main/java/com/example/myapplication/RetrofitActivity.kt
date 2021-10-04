package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityRetrofitBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // baseUrl = 공통적으로 들어가는 주소(도메인)
        // http://mellowcode.org/json/students/
        // http://mellowcode.org/test/code/
        val retrofit = Retrofit.Builder()
            .baseUrl( "http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>>{
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful){
                    val personList = response.body()
                    Log.d("retrofitt", "res : "+personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt","code : "+code)

                    val header = response.headers()
                    Log.d("retrofitt", "header : $header")
                }
            }

            // 보통 에러메시지를 보여주는 함수로 많이 쓰임
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt","error")
            }
        })

        // POST 요청 (1) --> HashMap으로 보내는것
//        val params = HashMap<String, Any>()
//        params.put("name","정유자")
//        params.put("age",20)
//        params.put("intro","야옹")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer>{
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if(response.isSuccessful){
//                    val person = response.body()
//                    Log.d("retrofitt","name : ${person?.name}")
//                }
//
//            }
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//            }
//        })

        // POST 요청(2) --> 객체를 만들어서 보내는것
        val person = PersonFromServer(name = "김철수", age = 12, intro = "안녕하세요 철수입니다")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer>{
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                val person = response.body()
                Log.d("retrofitt","name : ${person?.name}")
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }
        })


    }
}