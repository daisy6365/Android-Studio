package com.example.myapplication

//retrofit은 다양한url을 쉽게 관리할수 있게 만듦

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestrofitLibrary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restrofit_library)


//        http://mellowcode.org/json/studnets/
//        http://mellowcode.org/test/code/


        //retrofit 생성
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/") //베이스 URL넣어줌
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)
        //> retrofit 사용준비 완

        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")

            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofitt", "res : " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "code : " + code)

                    val header = response.headers()
                    Log.d("retrofitt", "code : " + header)
                }
            }
        })
        // POST 요청 (1) (정보추)
//        val params = HashMap<String, Any>()
//        params.put("name", "김개똥")
//        params.put("age", 20)
//        params.put("intro", "안녕하세요")
//        service.createStudnet(params).enqueue(object : Callback<PersonFromServer> {
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//            }
//
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : " + person?.name)
//                }
//
//            }
//        })
        // POST 요청 (2)가 -> 더 쉽게 하는 방법
        //객체를 넣어줌
        val person = PersonFromServer(name = "김철수", age = 12, intro = "안녕하세요 철수 입니다")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }

            }
        })
    }
}