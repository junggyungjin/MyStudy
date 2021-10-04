package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivitySharedPreferenceBinding
import com.example.myapplication.databinding.ActivityTabPagerBinding

class SharedPreferenceActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreference에 저장하는 방법
//        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        // MODE
        // - MODE_PRIVATE : 생성한 application에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 application 사용가능 -> 읽을수만 있다
        // - MODE_WORLD_WRITEABLEW : 다른 application 사용가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference에 신규로 추가

        binding.saveBtn.setOnClickListener {
            // SharedPreference에 저장하는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)

            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()

        }

        binding.loadBtn.setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터없음")
            val value2 = sharedPreference.getString("goodbye", "데이터없음")
            Log.d("key-value", "Value1 : " + value1)
            Log.d("key-value", "Value2 : " + value2)
        }

        binding.deleteBtn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }

        binding.deleteAllBtn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }

    }
}