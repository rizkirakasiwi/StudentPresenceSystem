package com.example.sipress.hiltModule

import com.example.sipress.presenter.HomePresenter
import com.example.sipress.presenter.HomePresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class HomePresenterModul {

    @Binds
    abstract fun homePresenter(homePresenterImpl: HomePresenterImpl):HomePresenter
}