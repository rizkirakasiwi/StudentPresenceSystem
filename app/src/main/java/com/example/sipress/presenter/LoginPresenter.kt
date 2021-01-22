package com.example.sipress.presenter

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.sipress.R
import com.example.sipress.ui.fragment.LoginFragmentDirections
import com.example.sipress.ui.viewModel.LoginViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface LoginPresenter {
    suspend fun signin(view: View, username:String, password:String)
    suspend fun signout()
}

class LoginPresenterImpl @Inject constructor(
    private val authPresenter: AuthPresenter
):LoginPresenter{
    companion object{
        private const val TAG ="LOGINPRESENTER"
    }


    override suspend fun signin(view:View, username: String, password: String) {
        val context = view.context

        //create loading dialog
        val loadingLayout = LayoutInflater.from(context).inflate(R.layout.loading_layout, null, false)
        val loadingDialog = AlertDialog.Builder(context)
                .setView(loadingLayout)
                .create()

        //alertdialog
        val alertDialog :(String, String) -> AlertDialog = { title, message->
            AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(context.getString(R.string.ok)) { _, _ -> }
                    .create()
        }


        loadingDialog.show()

        val signIn = withContext(Dispatchers.IO) {
            authPresenter.signIn<Task<AuthResult>>(username, password)
        }

        signIn.addOnSuccessListener {
            Log.i(TAG, "Login success..")
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            loadingDialog.dismiss()

        }.addOnFailureListener {

            Log.e(TAG, "Failed to login with : "+it.message.toString())

            val errorCode = (it as FirebaseAuthException).errorCode
            val errorMessage = LoginViewModel.authErrors[errorCode] ?: R.string.error_default_login
            alertDialog(context.getString(R.string.error), context.getString(errorMessage)).show()

        }
    }

    override suspend fun signout() {
        authPresenter.signOut()
    }

}