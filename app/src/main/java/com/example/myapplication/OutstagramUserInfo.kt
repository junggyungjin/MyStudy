package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityOutstagramUserInfoBinding

class OutstagramUserInfo : AppCompatActivity() {
    lateinit var binding: ActivityOutstagramUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutstagramUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.allList.setOnClickListener {
            startActivity(Intent(this, OutStargramPostListActivity::class.java))
        }

        binding.myList.setOnClickListener {
            startActivity(Intent(this, OutStagramMyPostListActivity::class.java))
        }

        binding.upload.setOnClickListener {
            startActivity(Intent(this, OutstagramUploadActivity::class.java))
        }

        binding.logout.setOnClickListener {
            (application as MasterApplication).logout()
            finish()
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}