package com.example.sipress.presenter

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.sipress.R
import com.example.sipress.data.SchoolData
import com.example.sipress.presenter.storage.AuthStoragePresenter
import com.example.sipress.presenter.storage.SchoolStoragePresenter
import com.example.sipress.ui.fragment.CheckNISFragmentDirections
import com.example.sipress.ui.viewModel.CheckNISViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface CheckNISPresenter {
    fun schoolsList():LiveData<List<SchoolData>?>
    fun batchList():LiveData<List<String>?>
    suspend fun loadSchools()
    suspend fun loadBatch(npsn:String)
    suspend fun checkAvailableNis(view:View, npsn: String, batch: String, nis: String)
}

class CheckNISPresenterImpl @Inject constructor(
    private val authStoragePresenter: AuthStoragePresenter,
    private val schoolStoragePresenter: SchoolStoragePresenter
):CheckNISPresenter {
    companion object{
        private const val TAG = "CheckNisPresenter"
    }

    private val _schools = MutableLiveData<List<SchoolData>?>()
    private val _batchList = MutableLiveData<List<String>?>()

    override fun schoolsList(): LiveData<List<SchoolData>?> = _schools

    override fun batchList(): LiveData<List<String>?> {
        return _batchList
    }

    override suspend fun loadSchools() {

        val getSchool = withContext(Dispatchers.IO){
            schoolStoragePresenter.getSchool<Task<QuerySnapshot>>()
        }

        val schoolList = mutableListOf<SchoolData>()

        getSchool[0].addOnSuccessListener {
            for (document in it){
                val schoolData = document.toObject<SchoolData>()
                schoolList.add(schoolData)
            }
            _schools.value = schoolList
        }.addOnFailureListener {
            Log.e(TAG, "failed to get school list with error ${it.message}")
            _schools.value = null
        }
    }

    override suspend fun loadBatch(npsn: String) {
        val batch = withContext(Dispatchers.IO){
            schoolStoragePresenter.getBatch<Task<QuerySnapshot>>(npsn)
        }

        batch[0].addOnSuccessListener {
            val batches = mutableListOf<String>()
            for (documents in it){
                val year = documents.id
                batches.add(year)
            }

            _batchList.value = batches
        }.addOnFailureListener {
            Log.e(TAG, "error to load batch with error ${it.message}")
            _batchList.value = null
        }
    }

    override suspend fun checkAvailableNis(view:View, npsn: String, batch: String, nis: String) {
         val checkNis = withContext(Dispatchers.IO){
             authStoragePresenter.checkAvailableNis<Task<QuerySnapshot>>(npsn,batch,nis)
         }

        val loadingLayout = LayoutInflater.from(view.context).inflate(
                R.layout.loading_layout, null, false
        )

        val loadingDialog = AlertDialog.Builder(view.context)
                .setView(loadingLayout)
                .create()

        val alertDialog:(String, String)->AlertDialog = {title, message ->
            AlertDialog.Builder(view.context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(view.context.getString(R.string.ok)){_,_->}
                    .create()
        }

        loadingDialog.show()

        checkNis.addOnSuccessListener {
            loadingDialog.dismiss()
            val bundle = bundleOf(CheckNISViewModel.SEND_NIS_CODE to nis)
            view.findNavController().navigate(R.id.action_checkNISFragment_to_inputOTPCodeFragment, bundle)
        }.addOnFailureListener {
            val firestoreException = (it as FirebaseFirestoreException).code.name
            Log.e(TAG, "failed to load existing NIS with error $firestoreException")
            val firestoreError = CheckNISViewModel.firestoreError[firestoreException] ?: R.string.error_default
            alertDialog(view.context.getString(R.string.error), view.context.getString(firestoreError)).show()
        }


    }
}