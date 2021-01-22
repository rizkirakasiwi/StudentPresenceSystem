package com.example.sipress.hiltModule

import com.example.sipress.presenter.LoginPresenter
import com.example.sipress.presenter.LoginPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class LoginPresenterModule {

    @Binds
    abstract fun loginPresenter(loginPresenterImpl: LoginPresenterImpl):LoginPresenter
}