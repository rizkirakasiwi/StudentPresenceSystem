package com.example.sipress.hiltModule

import com.example.sipress.presenter.ProfilePresenter
import com.example.sipress.presenter.ProfilePresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ProfilePresenterModule {

    @Binds
    abstract fun profilePresenter(profilePresenterImpl: ProfilePresenterImpl):ProfilePresenter
}