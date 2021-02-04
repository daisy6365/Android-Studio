package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        val button_save : Button = findViewById(R.id.save_btn)
        val button_delete : Button = findViewById(R.id.delete_button)
        val button_load: Button = findViewById(R.id.load_button)


        Realm.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        button_save.setOnClickListener {
            realm.executeTransaction {
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }

        button_load.setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data : " + data)
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
//                it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }
    }
}