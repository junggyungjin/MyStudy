package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.myapplication.databinding.ActivityOpenInternetBinding

class OpenInternet : AppCompatActivity() {

    private lateinit var binding: ActivityOpenInternetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInternet.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.addressEditText.text.toString()))
            startActivity(intent)
        }

        binding.addressEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit","beforeTextChanged : " + s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit","onTextChanged : " + s)
            }

            override fun afterTextChanged(s: Editable?) {
                if(s.toString() == "abc"){
                    Log.d("edit","text is abc")
                }
                Log.d("edit","afterTextChanged : " + s)
            }
        } )
    }
}