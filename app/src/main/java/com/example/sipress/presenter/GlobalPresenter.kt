package com.example.sipress.presenter

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ListAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

interface GlobalPresenter {
    fun<T> recyclerviewAdapter(data:List<T>, adapter:ListAdapter<T, *>):ListAdapter<T, *>
    fun viewPagerAdapter(fragment: Fragment, listFragment: List<Fragment>):FragmentStateAdapter
    fun addTabWithViewPager(tabLayout: TabLayout, viewPager2: ViewPager2, tabText:List<String>):TabLayoutMediator
}

class GlobalPresenterImpl @Inject constructor():GlobalPresenter{


    override fun <T> recyclerviewAdapter(data: List<T>, adapter:ListAdapter<T, *>): ListAdapter<T, *> {
        adapter.submitList(data)
        return  adapter
    }

    override fun viewPagerAdapter(fragment: Fragment, listFragment:List<Fragment>): FragmentStateAdapter {
        return object : FragmentStateAdapter(fragment){
            override fun getItemCount(): Int {
                return listFragment.count()
            }

            override fun createFragment(position: Int): Fragment {
                return listFragment[position]
            }

        }
    }

    override fun addTabWithViewPager(
        tabLayout: TabLayout,
        viewPager2: ViewPager2,
        tabText: List<String>
    ): TabLayoutMediator {
        return TabLayoutMediator(tabLayout, viewPager2){tab, position->
            tab.text = tabText[position]
        }
    }

}

