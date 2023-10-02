package com.jer.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class UserDetailActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2

        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val mAdapterTab = AdapterTab(this)
        val mViewPager: ViewPager2 = findViewById(R.id.view_pager)
        mViewPager.adapter = mAdapterTab
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, mViewPager) {tab, position ->
            tab.text = resources.getString(UserDetailActivity.TAB_TITLES[position])
        }.attach()
    }
}