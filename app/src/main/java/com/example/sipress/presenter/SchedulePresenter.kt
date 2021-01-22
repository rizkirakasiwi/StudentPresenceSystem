package com.example.sipress.presenter

import com.example.sipress.data.ScheduleData
import javax.inject.Inject

interface SchedulePresenter {
    fun loadScheduleByDay(day:String):ScheduleData
}

//class SchedulePresenterImpl @Inject constructor():SchedulePresenter{
//    override fun loadScheduleByDay(day: String): ScheduleData {
//        TODO("Not yet implemented")
//    }
//
//}