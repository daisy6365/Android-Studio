package com.example.myapplication
//Permission (권한)
//- 일반 권한
//    - 인터넷 사용 권한,
//    - Manifest에 등록만 하면 바로 사용 할 수 있다
//
//- 위험 권한
//    - 카메라, 연락처
//    -> 사용자에게 획득을 요청 해야 한다
//
//
//권한을 얻는 타이밍
//- 설치하자 마자 필요한 권한을 묻는 경우
//- 특정기능을 사용하려고 할때 묻는 경우 -> Best Practice
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        val ask : Button = findViewById(R.id.ask)


        ask.setOnClickListener {
            //카메라를 켜봄
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@PermissionActivity,
                android.Manifest.permission.CAMERA
            )
            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                //권한이 있는 경우
                Log.d("permissionsss", "권한이 이미 있음 ")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //승낙
                Log.d("permissionsss", "승낙")
            } else {
                //거부
                Log.d("permissionsss", "거부")
            }
        }
    }
}
