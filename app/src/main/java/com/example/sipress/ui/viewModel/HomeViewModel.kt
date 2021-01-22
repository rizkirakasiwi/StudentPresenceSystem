package com.example.sipress.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ListAdapter
import com.example.sipress.adapter.ScheduleAdapter
import com.example.sipress.data.ScheduleData
import com.example.sipress.presenter.HomePresenter

class HomeViewModel @ViewModelInject constructor(
    private val homePresenter: HomePresenter
) : ViewModel() {
    private val scheduleData = listOf(
        ScheduleData(
            "1",
            "Matematika",
            "07:00 s/d 09:00",
            "RPL2",
            "Khofia Nurkomsiska S.pd"
        ),
        ScheduleData(
            "2",
            "Sistem Operasi",
            "09:00 s/d 10:00",
            "RPL2",
            "Opie Sopiyan S.Kom"
        ),
        ScheduleData(
            "3",
            "Penjas",
            "11:30 s/d 12:00",
            "RPL2",
            "Ilham Setiadi S.pd"
        )
    )


    fun adapter(): ListAdapter<ScheduleData, *> {
        return homePresenter.adapter(scheduleData,ScheduleAdapter())
    }

}