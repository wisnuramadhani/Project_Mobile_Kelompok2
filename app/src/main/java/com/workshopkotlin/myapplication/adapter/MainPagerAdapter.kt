package com.workshopkotlin.myapplication.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.workshopkotlin.myapplication.feature.CartFragment
import com.workshopkotlin.myapplication.feature.ProductFragment
import com.workshopkotlin.myapplication.feature.ProfileFragment

class MainPagerAdapter(fm: FragmentManager, internal var context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = ProductFragment()
                return fragment
            }
            1 -> {
                fragment = CartFragment()
                return fragment
            }
            2 ->{
                fragment = ProfileFragment()
                return  fragment
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }
}