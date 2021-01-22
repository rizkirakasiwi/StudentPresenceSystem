package com.example.sipress.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.sipress.R

class CheckNISViewModel : ViewModel() {
    companion object{
        val firestoreError = mapOf(
                "ABORTED" to R.string.error_firestore_aborted,
                "CANCELLED" to R.string.error_firestore_cancelled,
                "DATA_LOSS" to R.string.error_firestore_data_loss,
                "NOT_FOUND" to R.string.error_firestore_not_found
        )

        const val SEND_NIS_CODE = "SendNis"
    }
}