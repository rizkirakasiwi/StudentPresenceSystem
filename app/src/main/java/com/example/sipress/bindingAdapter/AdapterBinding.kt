package com.example.sipress.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

@BindingAdapter("app:adapter")
fun<T> RecyclerView.adapter(adapter: ListAdapter<T, *>){
    this.adapter = adapter
}

@BindingAdapter("app:viewPagerAdapter")
fun ViewPager2.viewPagerAdapter(fragmentStateAdapter: FragmentStateAdapter){
    adapter = fragmentStateAdapter
}