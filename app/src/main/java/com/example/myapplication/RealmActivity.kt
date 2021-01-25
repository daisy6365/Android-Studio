package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        val button_save : Button = findViewById(R.id.button_save)
        val button_load : Button = findViewById(R.id.button_load)
        val button_delete : Button = findViewById(R.id.button_delete)

        //서로 연결해주고 관계성이 있기때문에 사용하기 어려움 -> 기능이 많음
        Realm.init(this@RealmActivity)

        //Realm 초기화
        val config: RealmConfiguration = RealmConfiguration.Builder()
            // migration(데이터베이스 동기화)이 필요한 경우에는 realm을 지움
            .deleteRealmIfMigrationNeeded() //초기화 단계 1
            .build() // 초기화 단계 2

        //realm을 얻어냄
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        // realm 사용
        button_save.setOnClickListener {
            // Transaction 실행(execute)
            realm.executeTransaction {
                // 테이블에서 데이터를 가져옴
                // 조함을 함
                // 새로운테이블에 저장을 함

                //테이블(틀) 넣음
                with(it.createObject(School::class.java)) {
                    this.name = "OO 대학교"
                    this.location = "서울"
                }
            }
        }

        button_load.setOnClickListener {
            realm.executeTransaction {
                // 데이터를 가져올때는 테이블에 먼저 접근해야함
                // it.where() -> 테이블 접근
                val data = it.where(School::class.java).findFirst()
                Log.d("data_a", "data : " + data)
            }
        }

        button_delete.setOnClickListener {
            realm.executeTransaction {
                // 테이블에 접근하여 데이터 전부삭제
                it.where(School::class.java).findAll().deleteAllFromRealm()
//                it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }
    }
}
