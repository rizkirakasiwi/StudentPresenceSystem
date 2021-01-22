package com.example.sipress.presenter.storage

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

interface AuthStoragePresenter {
    suspend fun<T> checkAvailableNis(npsn:String, batch:String, nis:String):T
}

class AuthStoragePresenterImpl @Inject constructor(
    private val firestore: FirebaseFirestore
):AuthStoragePresenter {

    override suspend fun <T> checkAvailableNis(npsn: String, batch: String, nis: String): T {
        val data = firestore.collection(npsn)
            .document("user")
            .collection("batch")
            .document(batch)
            .collection("nis")
            .document(nis)
            .get()

        return data as T
    }
}

