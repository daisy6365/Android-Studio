package com.example.myapplication

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApp:Application(){
    lateinit var service : RetrofitService

    override fun onCreate() {
        super.onCreate()

        // 스테토 init -> client에서 작동
        Stetho.initializeWithDefaults(this)

        //앱을 시작하자마자 createRetrofit() 실행
        //MasterApp -> onCreate -> createRetrofit() -> checkIsLogin() -> getUserToken() -> 서버에 토큰 전달
        createRetrofit()
        //chrome://inspect/#devices
    }


    fun createRetrofit(){
        //interceptor -> 중간에 가로챔
        //핸드폰으로부터 나가는 통신을 잡아둠 -> 오리지널 변수에 잡아 둠 -> 개조(header 넣음)
        val header = Interceptor{
            val original = it.request()

            //checkIsLogin 호출 -> 토큰값이 있는지 없는지 확인 -> 로그인을 했는지 안했는지를 검사
            //로그인을 했음 -> if절
            if(checkIsLogin() == true) {
                //토큰 부르기 -> null을 내보낼수 있음 (?)
                // null이 아닌 경우 let{}블럭 수행

                // [token -> ] => 원래 it이였음(==getUserToken() 값)
                // it으로 계속 사용 -> String에 해당 -> token변수로 변경하여
                // 서버관리에 token값을 넘겨줌
                getUserToken()?.let {token ->
                    val request = original.newBuilder()
                            //로그인 했으면 -> 아래 구문 실행
                            //로그인 x -> header 부분 작성 하지 않아도 됨
                            .header("Authorization","token " + token)
                            .build()
                    it.proceed(request)// 로그인 O -> request
                }
            }else {
                it.proceed(original)// 로그인X -> original
            }
        }

        val client = OkHttpClient.Builder()
                .addInterceptor(header)
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://mellowcode.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        service = retrofit.create(RetrofitService::class.java)
    }
    //로그인을 체크하는 함수
    fun checkIsLogin() : Boolean {
        // 로그인을 했는지 안했는지 알아봄
        // 기준이 있어야함 -> sharedpreference에 토큰값이 있냐 없냐로 구분
        // 가입을 한경우 --> 토큰을 받음
        // 토큰을 sharedpreference에 넣음 --> 로그인이 되어있는걸로 간주
        // sharedpreference에 토큰 없음 --> 로그인이 안되어있음

        //sharedpreference를 얻음
        //Context.MODE_PRIVATE
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp","null")
        if( token != "null") return true
        else return false
    }
    //토큰 값 가져오기
    //String?
    //로그인이 안된 경우에 -> null을 내보낼수 있도록함
    fun getUserToken():String? {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp","null")

        if(token == "null") return null
        else return token //토큰 값 내보내
    }
}