package com.example.sipress.ui.viewModel

import androidx.fragment.app.Fragment
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sipress.presenter.ProfilePresenter
import com.example.sipress.ui.fragment.ProfileAccountFragment
import com.example.sipress.ui.fragment.ProfilePersonalFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileViewModel @ViewModelInject constructor(
    private val profilePresenter: ProfilePresenter
) : ViewModel() {

    val tabText = listOf("Personal", "Akun")
    val listFragment = listOf(ProfilePersonalFragment(), ProfileAccountFragment())

    val tabLayoutMediator : (ViewPager2, TabLayout, List<String>) -> LiveData<TabLayoutMediator> = { viewPager2, tabLayout, tabText ->
        liveData {
            emit(
                profilePresenter.addProfileTabWithViewPager(tabLayout, viewPager2, tabText)
            )
        }
    }

    val viewPagerAdapter : (Fragment, List<Fragment>) -> LiveData<FragmentStateAdapter> = {fragment, listFragment ->
        liveData {
            emit(
                profilePresenter.profileViewPagerAdapter(fragment, listFragment)
            )
        }
    }


}