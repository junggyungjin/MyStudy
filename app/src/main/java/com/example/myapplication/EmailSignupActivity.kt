package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.databinding.ActivityEmailSignupBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class EmailSignupActivity : AppCompatActivity() {
    lateinit var binding: ActivityEmailSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailSignupBinding.inflate(layoutInflater)

        if((application as MasterApplication).checkIsLogin()){
            finish()
            startActivity(
                Intent(this@EmailSignupActivity, OutStargramPostListActivity::class.java))
        }else {
            setContentView(binding.root)
//        initView(this@EmailSignupActivity)    // 뷰바인딩으로 묶으면 초기화 안해도 되는듯?
            setupListener(this)
        }

    }

    fun setupListener(activity: Activity) {
        binding.register.setOnClickListener {
            Log.d("registerr","클릭되었습니다")
            register(this@EmailSignupActivity)
        }
        binding.login.setOnClickListener {
            startActivity(Intent(this@EmailSignupActivity, LoginActivity::class.java))
        }
    }

    fun register(activity: Activity) {
        val username = getUserName()
        val password1 = getUserPassword1()
        val password2 = getUserPassword2()

        // 마스터어플리케이션 클래스에 만들어둔 서비스라는 변수를 가져오는 방법
        // 부모클래스 as 자식클래스 다운캐스팅한것
        (application as MasterApplication).service.register(username, password1, password2)
            .enqueue(object : retrofit2.Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Toast.makeText(activity, "가입에 성공하였습니다", Toast.LENGTH_LONG).show()
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token, activity)
                        // 가입을 하고나면 한번 더 호출해줘야 한다. 처음 가입할땐 토큰값이 없었기때문에?
                        (application as MasterApplication).createRetrofit()
                        activity.startActivity(Intent(activity,OutStargramPostListActivity::class.java))
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(activity, "가입에 실패하였습니다", Toast.LENGTH_LONG).show()
                }
            })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }

    fun getUserName(): String {
        return binding.usernameInputbox.text.toString()
    }

    fun getUserPassword1(): String {
        return binding.password1Inputbox.text.toString()
    }

    fun getUserPassword2(): String {
        return binding.password2Inputbox.text.toString()
    }
}