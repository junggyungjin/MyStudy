package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityRealmBinding
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    lateinit var binding: ActivityRealmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Realm.init(this@RealmActivity)
        val config : RealmConfiguration = RealmConfiguration.Builder().allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        val realm = Realm.getDefaultInstance()

        binding.btnSave.setOnClickListener {
            realm.executeTransaction {
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
                // with함수를 안쓰면 밑의 코드처럼 쓰면 됨
//                it.createObject(School::class.java).name = "어떤 대하교"
//                it.createObject(School::class.java).location = "서울"
            }
        }

        binding.btnLoad.setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa","data : $data")
            }
        }

        binding.btnDelete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm() // 싹 다 지우기
//                it.where(School::class.java).findFirst().deleteFromRealm() //첫번째 행만 지우기
            }
        }

    }
}