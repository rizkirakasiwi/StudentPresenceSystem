package com.example.sipress.hiltModule

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseProvider {

    @Provides
    fun auth():FirebaseAuth{
        return Firebase.auth
    }

    @Provides
    fun firestore():FirebaseFirestore{
        return Firebase.firestore
    }

}