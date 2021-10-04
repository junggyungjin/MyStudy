package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityThreadBinding

class ThreadActivity : AppCompatActivity() {
    lateinit var binding: ActivityThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val runnable: Runnable = object : Runnable{
            override fun run() {
                Log.d("thread-1","Thread is made")
            }
        }
        val thread : Thread = Thread(runnable)

        binding.btn.setOnClickListener {
            thread.start()
        }

        Thread(object : Runnable{
            override fun run() {
                Log.d("thread-1","Thread2 is made")
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("thread-1","Thread3 is made")
            runOnUiThread {
                binding.btn.setBackgroundColor(getColor(R.color.textview_colr))
            }
        }).start()

    }
}