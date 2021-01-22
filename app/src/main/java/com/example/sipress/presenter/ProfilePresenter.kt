package com.example.sipress.presenter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

interface ProfilePresenter {
    fun profileViewPagerAdapter(fragment:Fragment, listFragment: List<Fragment>):FragmentStateAdapter
    fun addProfileTabWithViewPager(tabLayout: TabLayout, viewPager2: ViewPager2, tabText:List<String>):TabLayoutMediator
}

class ProfilePresenterImpl @Inject constructor(
    private val globalPresenter: GlobalPresenter
):ProfilePresenter{
    override fun profileViewPagerAdapter(fragment: Fragment, listFragment:List<Fragment>): FragmentStateAdapter {
        return globalPresenter.viewPagerAdapter(fragment, listFragment)
    }

    override fun addProfileTabWithViewPager(
        tabLayout: TabLayout,
        viewPager2: ViewPager2,
        tabText: List<String>
    ):TabLayoutMediator {
        return globalPresenter.addTabWithViewPager(tabLayout, viewPager2, tabText)
    }
}