package com.example.sipress.hiltModule

import com.example.sipress.presenter.AuthPresenter
import com.example.sipress.presenter.AuthPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthPresenterModule {

    @Binds
    abstract fun firebaseAuth(authPresenterImpl: AuthPresenterImpl):AuthPresenter
}