package com.example.sipress.presenter.storage

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

interface SchoolStoragePresenter {
    suspend fun<T> getSchool():List<T>
    suspend fun<T> getBatch(npsn:String):List<T>
}

class SchoolStoragePresenterImpl @Inject constructor(
        private val firestore: FirebaseFirestore
):SchoolStoragePresenter{


    override suspend fun<T> getSchool(): List<T> {
        val data = firestore.collection("SCHOOL")
            .document("list")
            .collection("npsn")
            .get()

        return listOf(data) as List<T>
    }

    override suspend fun <T> getBatch(npsn: String): List<T> {
        val data = firestore.collection(npsn)
            .document("user")
            .collection("batch")
            .get()

        return listOf(data) as List<T>
    }

}