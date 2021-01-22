package com.example.sipress.presenter

import androidx.recyclerview.widget.ListAdapter
import com.example.sipress.data.ScheduleData
import javax.inject.Inject

interface HomePresenter {
    fun adapter(data:List<ScheduleData>, adapter:ListAdapter<ScheduleData, *>):ListAdapter<ScheduleData, *>
}

class HomePresenterImpl @Inject constructor(
    private val globalPresenter: GlobalPresenter
):HomePresenter{
    override fun adapter(data: List<ScheduleData>, adapter: ListAdapter<ScheduleData, *>): ListAdapter<ScheduleData, *> {
        return globalPresenter.recyclerviewAdapter(data, adapter)
    }

}




