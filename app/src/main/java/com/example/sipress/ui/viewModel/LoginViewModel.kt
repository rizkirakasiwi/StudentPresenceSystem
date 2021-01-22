package com.example.sipress.ui.viewModel

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sipress.R
import com.example.sipress.presenter.LoginPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val loginPresenter: LoginPresenter
) : ViewModel() {
    companion object{
        val authErrors = mapOf(
                "ERROR_INVALID_EMAIL" to R.string.error_login_invalid_email,
                "ERROR_WRONG_PASSWORD" to R.string.error_login_wrong_password,
                "ERROR_USER_DISABLED" to R.string.error_login_user_disabled,
                "ERROR_USER_NOT_FOUND" to R.string.error_login_user_not_found,
                "ERROR_WEAK_PASSWORD" to R.string.error_login_password_is_weak)

        private const val TAG = "LOGINVIEWMODEL"
    }


    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()


    fun signIn(view:View, username:String, password:String){
        viewModelScope.launch(Dispatchers.Main) {
            loginPresenter.signin(view, username, password)
        }
    }
}

