package com.example.myapplication

//1. 리스트로 만들고 싶은 아이템의 리스트를 준비한다
//2. 인플레이터를 준비한다
//3. 인플레이터로 아이템 하나에 해당하는 뷰를 만들어 준다
//4. 위에서 만든 뷰를 컨터이너 뷰에 붙여준다
//
//ListView
//1. 리스트로 만들고 싶은 아이템의 리스트를 준비한다
//2. Adapter를 이용한다
//
//
//Addview와 ListView의 차이점
//1. 만드는 방식이 다르다 -> ListView는 Adapter 이용
//2. 그리는 방식이 다르다
//    - Addview -> 리스트의 갯수와 상관없이 한번에 다 그린다 (성능상 좋지 않음)
//    - ListView -> 보여지는 부분 + 알파만 한번에 그리고
//                  필요한 경우에 더 그린다
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
//        listView.adapter = adapter
        //리스너 등록
//        listView.setOnItemClickListener { parent, view, position, id ->
//            val carName = (adapter.getItem(position) as CarForList).name
//            val carEngine = (adapter.getItem(position) as CarForList).engine
//
//            Toast.makeText(this@ListViewActivity, carName + " " + carEngine, Toast.LENGTH_SHORT)
//                .show()
//        }
    }
}


class ListViewAdapter(
        val carForList: ArrayList<CarForList>,
        val layoutInflater: LayoutInflater
) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        //findviewid를 많이 사용하면 효율이 떨어짐
        //ViewHolder 이용
        val holder: ViewHolder

        if (convertView == null) {
            Log.d("convert", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()

            //findViewById로 찾은 다음에 holder에 집어넣음
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            // 찾을수있도록 태그를 달아 놓음
            view.tag = holder

        } else {
            //스크콜해서 다음 번째의 차를 생성
            //다시 그릴 일이 있을때 tag가져와서 내용 집어넣음
            //0번째를 다시 생성하여 새로운 차를 생성
            //넘어가는 것을 떼서 다시 새롭게 집어넣음
            Log.d("convert", "2")

            //재활용
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }


    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
        return position.toLong()
    }

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 갯수
        return carForList.size
    }
}

//ViewHolder class 생성
class ViewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}