package com.example.sipress.hiltModule

import com.example.sipress.presenter.GlobalPresenter
import com.example.sipress.presenter.GlobalPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class GlobalPresenterModule {

    @Binds
    abstract fun globalPresenter(globalPresenterImpl: GlobalPresenterImpl): GlobalPresenter
}