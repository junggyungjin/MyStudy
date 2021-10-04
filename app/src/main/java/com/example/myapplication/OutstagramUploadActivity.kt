package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.myapplication.databinding.ActivityOutstagramUploadBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutstagramUploadActivity : AppCompatActivity() {
    lateinit var binding: ActivityOutstagramUploadBinding
    lateinit var filePath: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutstagramUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPictures.setOnClickListener {
            getPicture()
        }

        binding.uploadPost.setOnClickListener {
            uploadPost()
        }

        tabCursor() // 탭이동
    }

    fun tabCursor() {
        binding.allList.setOnClickListener {
            startActivity(Intent(this@OutstagramUploadActivity, OutStargramPostListActivity::class.java))
        }

        binding.myList.setOnClickListener {
            startActivity(Intent(this@OutstagramUploadActivity, OutStagramMyPostListActivity::class.java))
        }

        binding.userInfo.setOnClickListener {
            startActivity(Intent(this@OutstagramUploadActivity, OutstagramUserInfo::class.java))
        }
    }

    // 카메라 앨범에 접근하는 함수
    fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 1000)
    }

    // 앨범에서 사용자가 어떤 사진을 선택했는지 알 수 있는 함수, 상대경로를 알아내는 함수
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1000){
            // Uri : 어떤 자료의 위치 , Url = 웹페이지의 주소, 위치
            val uri : Uri = data!!.data!!
            filePath = getImageFilePath(uri)
        }
    }

    // 절대경로를 알아내는 함수
    fun getImageFilePath(contentUri : Uri): String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA) // 걸러내기 위한 틀
        val cursor = contentResolver.query(contentUri, projection, null, null, null) // ContentResolver : 컨텐트를 관리하는 것
        // query : 검색해라
        if(cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost() {
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    finish()
                    startActivity(Intent(this@OutstagramUploadActivity, OutStagramMyPostListActivity::class.java))
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }
        })
    }

    fun getContent():String {
        return binding.contentInput.text.toString()
    }
}