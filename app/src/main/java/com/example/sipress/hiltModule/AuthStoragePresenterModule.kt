package com.example.sipress.hiltModule

import com.example.sipress.presenter.storage.AuthStoragePresenter
import com.example.sipress.presenter.storage.AuthStoragePresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthStoragePresenterModule {

    @Binds
    abstract fun authStoragePresenter(authStoragePresenterImpl: AuthStoragePresenterImpl):AuthStoragePresenter
}