package com.example.sipress.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sipress.utility.RecyclerviewPagination

@BindingAdapter("app:adapter")
fun<T> RecyclerView.adapter(adapter: ListAdapter<T, *>){
    this.adapter = adapter
}

@BindingAdapter("app:onScrollListener")
fun RecyclerView.OnScrollListener(linearLayoutManager: LinearLayoutManager){
    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    val paginationScroll = object : RecyclerviewPagination(linearLayoutManager){
        override fun isLastPage(): Boolean {
            return isLastPage
        }

        override fun isLoading(): Boolean {
           return isLoading
        }

        override fun loadMoreData() {

        }

    }
}

@BindingAdapter("app:viewPagerAdapter")
fun ViewPager2.viewPagerAdapter(fragmentStateAdapter: FragmentStateAdapter){
    adapter = fragmentStateAdapter
}