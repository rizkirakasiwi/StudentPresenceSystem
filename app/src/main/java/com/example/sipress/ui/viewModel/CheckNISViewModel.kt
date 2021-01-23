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

    fun showSearchSchoolDialog(view:View, schoolList: List<SchoolData>?) {
        checkNISPresenter.showAvailableSchool(view, schoolList)
    }


}