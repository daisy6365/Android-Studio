package com.example.myapplication

import android.widget.Button

//비동기 -> Async
//동기  -> Sync
//
//
//동기 방식
//- 작업을 순서대로 진행한다
//- A -> B -> C -> D
//- 위에서부터 아래로 실행
//
//비동기 방식
//- 쓰레드를 만들어서 작업을 따로 처리한다
//
//결과를 받는다
//---------------------------------------------->
//| |  | |  ||
//-------------
//작업
//
//안드로이드에서 Async 다루는 방법
//- AsyncTask상속받는다
//-> onPreExcute      : 쓰레드 출발하기전에 할 작업
//-> doIntBackground  : 쓰레드가 할 작업
//-> onPregressUpdate : 중간중간에 MainThread로 온다
//-> onPostExcute     : 작업을 다 마친후 MainThread
//
//Async의 장점
//- Main Thread를 기다리게 할 필요가 없다
//- 네트워크 작업
//
//Async의 단점
//- 재사용이 불가능 하다
//- 구현된 Activity가 종료될경우 따라서 종료 되지 않는다
//- AsyncTask는 하나만 실행될수 있다(병렬처리가 안된다)

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AsyncActivity : AppCompatActivity() {
    var task: BackgroundAsyncTask? = null
    var task1: BackgroundAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val ment :TextView = findViewById(R.id.ment)
        val progressbar :ProgressBar = findViewById(R.id.progressbar)
        val start : Button = findViewById(R.id.start)
        val stop : Button = findViewById(R.id.stop)

        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)
            task1 = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
            task1?.execute()
        }

        stop.setOnClickListener {
            //            task?.cancel(true)
            startActivity(Intent(this, Intent03_2::class.java))
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
    // params -> doInBackgournd 에서 사용할 타입
    // progess -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExecute 에서 사용할 타입
    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled() == false) {
            percent++
            Log.d("async", "percent : " + percent)
            if (percent > 100) {
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            } catch (e: Exception) {
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
        progressText.setText("작업이 취소되었습니다.")
    }
}
