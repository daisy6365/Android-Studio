package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)

    }

    //기본 10명으로 만들도록 초기화
   fun createFakePhoneBook(fakseNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook{ // PhoneBook 리턴
        for (i in 0 until fakseNumber){
            phoneBook.addPerson(
                Person(name = ""+i+"번째 사람", number = ""+"010-"+i+i+i+i+"-"+i+i+i+i)
            )
        }
        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook){
        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
        //사람 수 만큼 item뷰 생성
        for(i in 0 until phoneBook.personList.size){
            val view = layoutInflater.inflate(R.layout.activity_phonebook_item,null)
            val personNameView = view.findViewById<TextView>(R.id.name)
            //뷰에 있는 이름에 personList에 저장된 이름을 붙여 넣음
            personNameView.setText(phoneBook.personList.get(i).name)

            // 반복문안에서 addSetOnClickListner호출
            // --> item뷰를 하나 만들면 만들어진 뷰에 addSetOnClickListne를 달아줌
            // 반복문을 통해 다음 item뷰를 생성시에도 똑같이 리스너를 달아줌
            addSetOnClickListner(phoneBook.personList.get(i), view) // 인덱스에 해당하는 사람의 정보와 뷰를 넘김

            //mainactivity container에 item뷰를 집어 넣음
            container.addView(view)
        }
    }

    // item뷰를 클릭 했을때 상세 전화번호부로 갈수 있게 하는 함수
    fun addSetOnClickListner(person:Person, view: View){
        view.setOnClickListener{
            // 인텐트 생성하여 PhoneBookActivity --> PhoneBookDetail로 갈수 있게 함
            val intent = Intent(this@PhoneBookActivity, PhoneBookDetail::class.java)

            // 해당 PhoneBookDetail에 정보(이름, 전화번호)를 넣어줌
            intent.putExtra("name",person.name)
            intent.putExtra("number",person.number)
            // 인텐트 출발
            startActivity(intent)
        }
    }
}

//클래스 생성 -> 전화번호부
class PhoneBook() {
    // 배열 : 여러사람을 배열로써 생성 [사람1[이름1, 번호1], 사람2[이름2, 번호2], 사람3[이름3, 번호3], 사람4[이름4, 번호4]]
    val personList = ArrayList<Person>()

    fun addPerson(person: Person){
        personList.add(person)
    }
}
class Person(val name: String, var number: String){
 // 사람의 정보 (이름, 핸드폰)
}