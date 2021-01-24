package com.example.sipress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sipress.data.SchoolData
import com.example.sipress.databinding.SearchToChoiceLayoutItemBinding

class SearchToChoiceAdapter(
    private val listOfOptions:List<String>?,
    private val schoolList:List<SchoolData>?):RecyclerView.Adapter<SearchToChoiceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchToChoiceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = SearchToChoiceLayoutItemBinding.inflate(inflater, parent, false)
        return SearchToChoiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchToChoiceViewHolder, position: Int) {
        if (listOfOptions != null){
            holder.bind(listOfOptions[position])
        }else{
            holder.bind(schoolList?.get(position)?.name)
        }
    }

    override fun getItemCount(): Int = listOfOptions?.count() ?: schoolList!!.count()
}

class SearchToChoiceViewHolder(private val binding:SearchToChoiceLayoutItemBinding)
    :RecyclerView.ViewHolder(binding.root){
        fun bind(text:String?){
            binding.titleText = text
        }
    }