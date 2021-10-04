package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.databinding.ActivityAsyncAcitivityBinding
import java.lang.Exception

class AsyncAcitivity : AppCompatActivity() {
    lateinit var binding: ActivityAsyncAcitivityBinding
    var task : BackgroundAsyncTask? = null
    var task1 : BackgroundAsyncTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            task = BackgroundAsyncTask(binding.progressbar, binding.ment)
            task1 = BackgroundAsyncTask(binding.progressbar, binding.ment)
            task?.execute()
            task1?.execute()
        }

        binding.stop.setOnClickListener {
            task?.cancel(true)
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressbar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // params -> doInBackground 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExcute 에서 사용할 타입
    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled() == false) {
            percent++
            Log.d("sync","percent : $percent")
            if (percent > 100) {
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트 : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다")
        super.onCancelled()
    }
}