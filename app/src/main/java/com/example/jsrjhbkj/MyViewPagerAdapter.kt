package com.example.jsrjhbkj

import com.example.jsrjhbkj.MyViewPagerAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import fragment1
import fragment2
import fragment3

class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragment1()
            1 -> fragment2()
            2 -> fragment3()
            else -> fragment1()
        }
    }


    override fun getItemCount(): Int {
        return 3
    }
}