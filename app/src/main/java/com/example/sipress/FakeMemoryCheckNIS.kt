package com.example.sipress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sipress.data.SchoolData

object FakeMemoryCheckNIS {
    private val _schoolList = MutableLiveData<List<SchoolData>?>()
    val schoolList : LiveData<List<SchoolData>?> get() = _schoolList

    fun addSchoolList(data:List<SchoolData>?){
        _schoolList.value = data
    }
}