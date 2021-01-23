package com.example.sipress.hiltModule

import com.example.sipress.presenter.CheckNISPresenter
import com.example.sipress.presenter.CheckNISPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CheckNISPresenterModule{

    @Binds
    abstract fun checkNISPresenter(checkNISPresenterImpl: CheckNISPresenterImpl):CheckNISPresenter
}