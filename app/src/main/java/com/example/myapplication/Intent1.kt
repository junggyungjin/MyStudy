package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityIntentBinding

class Intent1 : AppCompatActivity() {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeActivity.setOnClickListener {
//            val intent = Intent(this@Intent1, Intent2::class.java)
//
//            // Key, value 방식 -> key와 Value를 쌍으로 만들어 저장한다 -> dictionary
//            intent.putExtra("number1",1)
//            intent.putExtra("number2",2)
//            startActivity(intent)

//            val intent2 = Intent(this@Intent1,Intent2::class.java)
//            // Apply ->
//            intent2.apply {
//                this.putExtra("number1",1)
//                this.putExtra("number2",2)
//            }
//            startActivityForResult(intent2,200)

            // 암시적 인텐트
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200){
            Log.d("number",""+requestCode)
            Log.d("number",""+resultCode)
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
        }

    }
}