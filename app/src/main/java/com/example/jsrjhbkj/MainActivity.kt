package com.example.jsrjhbkj

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.jsrjhbkj.MyViewPagerAdapter
import com.example.jsrjhbkj.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var myViewPagerAdapter: MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Make sure you have the correct layout resource ID

        tabLayout = findViewById(R.id.tab_layout)
        viewPager2 = findViewById(R.id.view_pager)
        myViewPagerAdapter = MyViewPagerAdapter(this)
        viewPager2.adapter = myViewPagerAdapter // Use the 'adapter' property

        tabLayout?.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2?.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        viewPager2?.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout?.getTabAt(position)?.select()
            }
        })
    }
}
