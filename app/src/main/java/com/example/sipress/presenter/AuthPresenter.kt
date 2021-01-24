package com.example.sipress.presenter

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

interface AuthPresenter {
    suspend fun currentUser():FirebaseUser?
    suspend fun<T> createUserWithEmailAndPassword(user:String, password:String):T
    suspend fun<T> signIn(user: String, password: String):T
    suspend fun signOut()
}

class AuthPresenterImpl @Inject constructor(
    private val auth:FirebaseAuth
):AuthPresenter{
    companion object{
        private const val TAG = "AUTHPRESENTER"
    }

    private val emailDomain = "@sipress.com"

    override suspend fun currentUser(): FirebaseUser? {
        return auth.currentUser
    }

    override suspend fun<T> createUserWithEmailAndPassword(user: String, password: String): T {
        Log.v(TAG, "user try to create new account..")

        val username = user + emailDomain
        val createUser = auth.createUserWithEmailAndPassword(username, password)
        return createUser as T

    }

    override suspend fun<T> signIn(user: String, password: String): T {
        Log.v(TAG, "user try to login..")
        val username = user + emailDomain
        val signIn = auth.signInWithEmailAndPassword(username, password)
        return signIn as T
    }

    override suspend fun signOut() {
        Log.i(TAG, "user sign out..")
        auth.signOut()
    }


}