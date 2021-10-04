package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityListenerBinding
import com.example.myapplication.databinding.ActivityMainBinding

class Listener : AppCompatActivity() {

    private lateinit var binding: ActivityListenerBinding
    var num = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListenerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvHello.setOnClickListener {
            Log.d("click", "Click!!")
            binding.tvHello.setText("안녕하세요")
            binding.image.setImageResource(R.drawable.sky)
            num += 10
            Log.d("number", ""+num)
        }



//        val hello: TextView = findViewById(R.id.hello)

        //익명함수
        // 1 -> 람다방식
//        hello.setOnClickListener {
//            Log.d("click", "Click!!")
//        }
//
//        // 2 -> 익명 함수 방식
//        hello.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Log.d("click", "Click!!")
//            }
//        })
//
//        // 3 -> 이름이 필요한 경우(click)
//        val click = object : View.OnClickListener {
//            override fun onClick(v: View?) {
//            }
//        }
//
//        hello.setOnClickListener(click)

        //뷰를 조작하는 함수들
        // 1> setText
        // 2> setImageResource
        
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")
    }
}