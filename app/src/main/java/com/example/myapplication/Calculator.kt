package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    // new -> old (new + old)
    var new = "0"
    var old = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Cal()

    }

    fun Cal(){
        binding.tv1.setOnClickListener {
            new = new + "1"
            binding.tvResult.setText(new)
        }

        binding.tv2.setOnClickListener {
            new = new + "2"
            binding.tvResult.setText(new)
        }

        binding.tv3.setOnClickListener {
            new = new + "3"
            binding.tvResult.setText(new)
        }

        binding.tv4.setOnClickListener {
            new = new + "4"
            binding.tvResult.setText(new)
        }

        binding.tv5.setOnClickListener {
            new = new + "5"
            binding.tvResult.setText(new)
        }

        binding.tv6.setOnClickListener {
            new = new + "6"
            binding.tvResult.setText(new)
        }

        binding.tv7.setOnClickListener {
            new = new + "7"
            binding.tvResult.setText(new)
        }

        binding.tv8.setOnClickListener {
            new = new + "8"
            binding.tvResult.setText(new)
        }

        binding.tv9.setOnClickListener {
            new = new + "9"
            binding.tvResult.setText(new)
        }

        binding.tv0.setOnClickListener {
            new = new + "0"
            binding.tvResult.setText(new)
        }

        binding.tvPlus.setOnClickListener {
            old = (old.toInt() + new.toInt()).toString()
            new = "0"
            binding.tvResult.setText(old)
        }

        binding.tvCa.setOnClickListener {
            new = "0"
            old = "0"
            binding.tvResult.setText("0")
        }

    }
}