package com.example.sipress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sipress.data.ScheduleData
import com.example.sipress.databinding.ScheduleRecyclerviewLayoutBinding
private var isColor = true


class ScheduleAdapter:ListAdapter<ScheduleData, ScheduleViewHolder>(ScheduleDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ScheduleRecyclerviewLayoutBinding.inflate(inflater, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ScheduleViewHolder(private val binding:ScheduleRecyclerviewLayoutBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(scheduleData: ScheduleData){
        isColor = !isColor
        binding.isColor = isColor
    }
}

class ScheduleDiffUtil:DiffUtil.ItemCallback<ScheduleData>(){
    override fun areContentsTheSame(oldItem: ScheduleData, newItem: ScheduleData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: ScheduleData, newItem: ScheduleData): Boolean {
        return oldItem == newItem
    }

}