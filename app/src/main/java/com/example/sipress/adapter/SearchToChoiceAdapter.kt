package com.example.sipress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sipress.data.SchoolData
import com.example.sipress.databinding.SearchToChoiceLayoutItemBinding

class SearchToChoiceAdapter:ListAdapter<SchoolData,SearchToChoiceViewHolder>(DiffUtilSearchToChoice()) {
    companion object{
        private const val TAG = "SearchToChoice"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchToChoiceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = SearchToChoiceLayoutItemBinding.inflate(inflater, parent, false)
        return SearchToChoiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchToChoiceViewHolder, position: Int) {
        holder.bind(getItem(position).name)
    }
}

class DiffUtilSearchToChoice:DiffUtil.ItemCallback<SchoolData>(){
    override fun areItemsTheSame(oldItem: SchoolData, newItem: SchoolData): Boolean {
        return oldItem.npsn == newItem.npsn
    }

    override fun areContentsTheSame(oldItem: SchoolData, newItem: SchoolData): Boolean {
        return oldItem == newItem
    }


}

class SearchToChoiceViewHolder(private val binding:SearchToChoiceLayoutItemBinding)
    :RecyclerView.ViewHolder(binding.root){
        fun bind(text:String?){
            binding.titleText = text
        }
    }