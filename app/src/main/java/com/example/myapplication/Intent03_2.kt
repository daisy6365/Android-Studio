package com.example.myapplication

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent03_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent03_2)


        val mngr =
                getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val taskList = mngr.getRunningTasks(10)
        taskList.forEachIndexed { index, runningTaskInfo ->
            Log.d("abc", ""+runningTaskInfo.topActivity?.getClassName())
        }

        val result : Button = findViewById(R.id.result)
        result.setOnClickListener {



//            val number1 = intent.getIntExtra("number1", 0)
//            val number2: Int = intent.getIntExtra("number2", 0)
//
//            Log.d("number", "" + number1)
//            Log.d("number", "" + number2)
//
//            val result = number1 + number2
//
//            val resultIntent = Intent()
//            resultIntent.putExtra("result", result)
//
//
//            setResult(Activity.RESULT_OK, resultIntent)
//            finish()// -> Activity 종료


            // Stack
            // Intent2   ->종료
            // Intent1          Intent1
        }

    }
}