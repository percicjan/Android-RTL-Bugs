package com.nap.rtlbugs

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.viewpager_activity.*

class ViewPagerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ASDASD", "onCreate")
        setContentView(R.layout.viewpager_activity)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        for (index in 1..5) {
            Log.d("ASDASD", "Creating fragment $index")
            adapter.addFragment(ViewPagerFragment.newInstance(index), index.toString())
        }
        viewPager.adapter = adapter

        Log.d("ASDASD", "Setting up viewpager")
        tabLayout.setupWithViewPager(viewPager)
    }


    class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        private val fragments: MutableList<Fragment> = mutableListOf()
        private val fragmentTitles: MutableList<String> = mutableListOf()

        override fun getItem(position: Int) = fragments[position]

        override fun getCount() = fragments.size

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            fragmentTitles.add(title)
        }

        override fun getPageTitle(position: Int) = fragmentTitles[position]

    }
}