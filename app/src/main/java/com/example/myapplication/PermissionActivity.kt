package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    lateinit var binding: ActivityPermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ask.setOnClickListener {
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@PermissionActivity,
                android.Manifest.permission.CAMERA
            )

            if(cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                //권한이 없는경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            }else {
                // 권한이 있는 경우
                Log.d("permissionsss","권한이 이미 있음")
            }
        }
    }

    // 내가 보낸 권한 요청에 대한 대답을 확인한는 함수
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1000) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //스안ㄱ
                Log.d("permissionsss","승낙")
            }else{
                //거부
                Log.d("permissionsss","거부")
            }
        }
    }
}