package com.example.sipress.ui.viewModel

import android.app.AlertDialog
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sipress.R
import com.example.sipress.data.SchoolData
import com.example.sipress.presenter.CheckNISPresenter
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CheckNISViewModel @ViewModelInject constructor(
        private val checkNISPresenter: CheckNISPresenter
): ViewModel() {
    companion object{
        val firestoreError = mapOf(
                "ABORTED" to R.string.error_firestore_aborted,
                "CANCELLED" to R.string.error_firestore_cancelled,
                "DATA_LOSS" to R.string.error_firestore_data_loss,
                "NOT_FOUND" to R.string.error_firestore_not_found
        )

        const val SEND_NIS_CODE = "SendNis"
    }

    private val _school = MutableLiveData<SchoolData?>()
    val school : LiveData<SchoolData?> get() = _school

    private val _batch = MutableLiveData<String?>()
    val batch : LiveData<String?> get() = _batch

    val schoolList:LiveData<List<SchoolData>?> get() = checkNISPresenter.schoolsList()
    val batchList:LiveData<List<String>?> get()=checkNISPresenter.batchList()


    fun loadSchoolList()=viewModelScope.launch(Dispatchers.Main){
        checkNISPresenter.loadSchools()
    }

    fun loadBatch(npsn:String)=viewModelScope.launch(Dispatchers.Main){
        checkNISPresenter.loadBatch(npsn)
    }

    fun selectSchool(view:View, list:List<SchoolData>){

    }
    fun checkNIS(view: View, npsn: String, batch: String, nis: String)=viewModelScope.launch(Dispatchers.Main){
        checkNISPresenter.checkAvailableNis(view, npsn, batch, nis)
    }



}