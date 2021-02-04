package com.example.myapplication
// master
//Fast_Campus_Android/app/src/main/java/com/example/myapplication/Android/18.Network
//Go to file
//
//@changja88
//changja88 save
//Latest commit 9f44bd9 on 4 Mar 2020
// History
// 1 contributor
//75 lines (56 sloc)  1.52 KB
//RawBlame
//
//
//네트워크
//-> 통신
//->
//
//DataBase <-----> Server <------> Client(app,web,...)
//  글                                 A
//  댓글                                B
//
//Local DataBase 의 한계
//- 동기화가 어렵다
//- 상호작용이 불가능 하다 -> 클라이언트와 데이터베이스사이에 서버가 관리해줌
//
//
//서버와 통신하는 방법
//- 해당 url로 요청한다
//- 인증정보를 보낸다(로그인)
//- JSON 형식을 사용해서 data를 보낸다
// postman
//- JavaScript Object Notation -> Javascript에서 객체를 만들 때 사용하는 표현식
//
//JSON 형식
//- [] -> List
//- {} -> 객체(인덱스)
//    -> "" -> 문자열
//    -> ""없으면 -> 숫자
//
//
//Json Response
//[
//    {
//        "id": 1,                -> (데이터형 아는 방법) 문서에 써있다
//        "name": "홍길동",
//        "age": 20,
//        "intro": "나는 홍길동이다!"
//    },
//    {
//        "id": 2,
//        "name": "김아무개",
//        "age": 10,
//        "intro": "난 김아무개 입니다 :)"
//    }
//]
//
//Json Parsing
//-> Json을 코틀린이나 자바가 이해할수 있게 변형 하는 과정
//
//Serializable (직렬화)
//----------------------->
//  id, name, age, intro
//
//코틀린이나/ 자바가 이해할수 있는 틀
//
//class Person(
//    var id : Int? = null
//    var name : String? = null
//    var age : Int? = null
//    var intro : String? = null
//)
//
//Person(1,"김아무개", 20, "안녕하세요")
//
//
//Request Type                Status Code
//- GET    -> 정보 요청       -> 200 OK
//- POST   -> 정보 추가 요청   -> 201 Created
//- DELETE -> 정보 삭제 요청
//- PUT    -> 정보 수정 요청
//
//Status Code
//- 200번대 -> 처리가 잘 됬다
//
//
//Library
//- Volly
//- Retrofit
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        val recycler_person : RecyclerView = findViewById(R.id.recycler_view)

        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@NetworkActivity)
        ).execute()

    }
}

class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
) : AsyncTask<Any?, Any?, Array<PersonFromServer>>() {
    override fun onPostExecute(result: Array<PersonFromServer>?) {
        // 여기는 UI 쓰레드에 접근 가능 하기 때문에 여기에서 뷰를 그려준다
        val adapter = PersonAdapter(result!!, inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> {
        val urlString: String = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""
        //200OK인 경우 --> UTF-8 형식으로 데이터를 읽음
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }

        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
        return data
    }
}


class PersonAdapter(
    val personList: Array<PersonFromServer>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            name = itemView.findViewById(R.id.person_name)
            age = itemView.findViewById(R.id.person_age)
            intro = itemView.findViewById(R.id.person_ment)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.person_list_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name ?: "")
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro ?: "")
    }
}
