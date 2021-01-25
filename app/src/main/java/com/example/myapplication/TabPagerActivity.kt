package com.example.myapplication
//Tablayout, Pager
//
//Pager
//- 종이 넘기듯이 화면을 넘겨는 역할
//
//TabLaout
//- tab을 담당하는 역할
//
//Adapter
//- Tablayout 과 pager를 연결해주는 역할
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        val tab_layout: TabLayout = findViewById(R.id.tab_layout)
        val view_pager: ViewPager = findViewById(R.id.view_pager)


        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        //새로운 페이지가 리스트가 아닌 수평으로 구성(경계가 안보임)
        //스와이프를 하면 새로운 페이지가 열리도록 구성
        //fragment 사용
        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter

        //tablelayout과 pager연결
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.setCurrentItem(tab!!.position)
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        // -> 페이져가 이동했을때 탭을 이동시키는 코드

    }
}

//pager를 3개나 만들려면 fagment도 3개를 만들어 줘야함
// Fragment
class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        // 리턴 타입 -> Fragment
        // 포지션에 해당하는 fragment를 리턴해야함
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }
            else -> return Fragment1()
        }

    }

    override fun getCount(): Int {
        // 전체 사이즈 리턴
        return tabCount
    }
}

