package com.example.ourcourage.android.di

import com.example.ourcourage.android.data.repository.HomeRepositoryImpl
import com.example.ourcourage.android.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

}