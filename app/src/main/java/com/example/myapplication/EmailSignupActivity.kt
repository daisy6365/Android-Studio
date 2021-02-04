package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignupActivity : AppCompatActivity() {
    //늦게 입력하므로 lateinit 사용
    lateinit var usernameView : EditText
    lateinit var userpwView : EditText
    lateinit var userpwckView : EditText

    lateinit var join_btn : Button
    lateinit var login_btn : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signup)

        // 순서 바뀌지 않도록!!!
        initView(this@EmailSignupActivity)
        setupListener()


    }
    fun setupListener() {
        join_btn.setOnClickListener {
            // 가입 버튼을 클립하면 register() 함수 호출
            register(this@EmailSignupActivity)

        }
    }

    fun register(activity: Activity){
        // 가입절차 진행
        val userName = usernameView.text.toString()
        val passWord = userpwView.text.toString()
        val passWordck = userpwckView.text.toString()
        val register  = Register(userName,passWord,passWordck)

        //MasterApp에서 만들었던 service(retrofit 결과물)를 가져옴 -> 통신
        // 해당 코드는 MasterApp의 변수와 함수에 접근이 가능
        (application as MasterApp).service.register(register).enqueue(object :
                Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity,"가입에 실패하였습니다." ,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    Toast.makeText(activity,"가입에 성공하였습니다.", Toast.LENGTH_LONG).show()
                    // 그 결과로 토큰을 받음
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token,activity)
                }
            }
        })
    }

    //받은 토큰은 sharedPreference에 저장
    fun saveUserToken(token : String, activity : Activity){
        //sharedPregerence 얻어옴
        val sp = activity.getSharedPreferences("login_sp",Context.MODE_PRIVATE)

        val editor = sp.edit()
        editor.putString("lonin_sp",token)
        editor.commit()
    }



    fun initView(activity : Activity){
        usernameView = findViewById(R.id.join_id)
        userpwView = findViewById(R.id.join_pw)
        userpwckView = findViewById(R.id.join_pwck)
        join_btn = findViewById(R.id.join_btn)
        login_btn = findViewById(R.id.login_btn)
    }

    // 만들어놓은 뷰에서 id,pw 가져옴
    fun getUserName():String{
        return usernameView.text.toString()
    }
    fun getUserPW():String{
        return userpwView.text.toString()
    }
    fun getUserPwck():String{
        return userpwckView.text.toString()
    }

}