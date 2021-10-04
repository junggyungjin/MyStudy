package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.myapplication.databinding.ActivityMytubedetailBinding

class MytubedetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMytubedetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMytubedetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("video_url")

        val mediaController = MediaController(this@MytubedetailActivity)
        binding.videoView.setVideoPath(url)
        binding.videoView.requestFocus()
        binding.videoView.start()
        mediaController.show()

        // Exoplayer --> 구글에서 만든 전문적인 영상 재생 기능
        // drm -> digital right management
    }
}