package com.example.sipress.ui.viewModel

import android.util.Log
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sipress.presenter.AuthPresenter
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LandingViewModel @ViewModelInject constructor(
    private val authPresenter: AuthPresenter
): ViewModel() {
    private val TAG = "LandingViewModel"
    private val _currentUser = MutableLiveData<FirebaseUser?>()
    val currentUser : LiveData<FirebaseUser?> get() = _currentUser

    fun checkUserSessionLogin() = viewModelScope.launch{
        authPresenter.signOut()
        val userActive = withContext(Dispatchers.IO){
            authPresenter.currentUser()
        }

        launch(Dispatchers.Main){
            _currentUser.value = userActive
            Log.i(TAG, "check user session login..")
            Log.i(TAG, "current user -> ${userActive?.uid}")
        }
    }
}