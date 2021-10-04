package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.myapplication.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity()/*, FragmentOne.OnDataPassListener*/ {

    private lateinit var binding : ActivityFragmentBinding

//    override fun onDataPass(data: String?) {
//        Log.d("pass",""+data)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("life_cycle","onCreate")


        val fragmentOne : FragmentOne = FragmentOne()
        //액티비티에서 프라그먼트로 data를 넣어주는 방법
        val bundle : Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        binding.btn.setOnClickListener {
            //프라그먼트를 동적으로 작동하는 방법
            // 프라그먼트를 붙이는 방법 replace/add
            val fragmentManager : FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction()

            // contain 자리에 fragmentOne이 나오게 됨
            fragmentTransaction.replace(R.id.contain, fragmentOne)
            fragmentTransaction.commit()
            // 끝을 내는 방법
            // commit    -> 시간 될 때 해
            // commitnow -> 지금 당장해
        }

        binding.btn2.setOnClickListener {
            // 프라그먼트 remove/detach 하는방법
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
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