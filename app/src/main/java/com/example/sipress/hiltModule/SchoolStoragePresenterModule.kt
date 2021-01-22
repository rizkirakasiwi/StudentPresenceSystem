package com.example.sipress.hiltModule

import com.example.sipress.presenter.storage.SchoolStoragePresenter
import com.example.sipress.presenter.storage.SchoolStoragePresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SchoolStoragePresenterModule {

    @Binds
    abstract fun schoolStoragePresenter(schoolStoragePresenterImpl: SchoolStoragePresenterImpl):SchoolStoragePresenter
}