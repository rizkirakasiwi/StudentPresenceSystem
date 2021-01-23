package com.example.sipress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sipress.data.FakeData
import com.example.sipress.databinding.SearchToChoiceLayoutBinding

class SearchToChoiceDiffUtil<T>:DiffUtil.ItemCallback<FakeData<T>>(){
    override fun areItemsTheSame(oldItem: FakeData<T>, newItem: FakeData<T>): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FakeData<T>, newItem: FakeData<T>): Boolean {
        return oldItem == newItem
    }

}


class SearchToChoiceAdapter<T> (private val viewHolderCode:Int)
    :ListAdapter<FakeData<T>, RecyclerView.ViewHolder>(SearchToChoiceDiffUtil<T>()) {
    companion object{
        const val SHOWSCHOOL = 0
        const val SHOWBATCH = 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SearchToChoiceLayoutBinding.inflate(inflater, parent, false)
        return when(viewHolderCode){
            SHOWSCHOOL -> SearchForSchoolViewHolder(binding)
            SHOWBATCH -> SearchForBatch(binding)
            else -> throw Throwable("viewHolder code is not available")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}
