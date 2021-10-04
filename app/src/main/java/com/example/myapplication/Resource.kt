package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityResourceBinding

lateinit var binding : ActivityResourceBinding

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //1
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment : $ment")

        //2
        val ment2 = getString(R.string.hello)
        Log.d("ment", "ment : $ment2")

        //3-1
        val color = getColor(R.color.textview_colr)
        Log.d("color", "color : $color")

        // 3-2 SDK 버전에 따른 분기 처리
        // val color = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        //     getColor(R.color.textview_color)
        //} else {
        //    resources.getColor(R.color.textview_color)
        //}

        binding.button.setBackgroundColor(getColor(R.color.textview_colr))

    }
}