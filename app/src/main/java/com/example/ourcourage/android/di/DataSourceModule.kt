package com.example.ourcourage.android.di

import com.example.ourcourage.android.data.datasource.remote.HomeRemoteDataSource
import com.example.ourcourage.android.data.datasource.remote.MyPageRemoteDataSource
import com.example.ourcourage.android.data.datasource.remote.PointRemoteDataSource
import com.example.ourcourage.android.data.datasource.remote.impl.HomeRemoteDataSourceImpl
import com.example.ourcourage.android.data.datasource.remote.impl.MyPageRemoteDataSourceImpl
import com.example.ourcourage.android.data.datasource.remote.impl.PointRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindHomeRemoteDataSource(homeRemoteDataSourceImpl: HomeRemoteDataSourceImpl): HomeRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindMyPageRemoteDataSource(myPageRemoteDataSourceImpl: MyPageRemoteDataSourceImpl): MyPageRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindPointRemoteDataSource(pointRemoteDataSourceImpl: PointRemoteDataSourceImpl): PointRemoteDataSource
}
