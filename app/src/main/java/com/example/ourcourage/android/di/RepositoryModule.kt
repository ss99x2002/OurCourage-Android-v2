package com.example.ourcourage.android.di

import com.example.ourcourage.android.data.repository.HomeRepositoryImpl
import com.example.ourcourage.android.data.repository.MultiUseRepositoryImpl
import com.example.ourcourage.android.data.repository.MyPageRepositoryImpl
import com.example.ourcourage.android.data.repository.PointRepositoryImpl
import com.example.ourcourage.android.domain.repository.HomeRepository
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import com.example.ourcourage.android.domain.repository.MyPageRepository
import com.example.ourcourage.android.domain.repository.PointRepository
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

    @Binds
    @Singleton
    abstract fun bindMyPageRepository(myPageRepositoryImpl: MyPageRepositoryImpl): MyPageRepository

    @Binds
    @Singleton
    abstract fun bindPointRepository(pointRepositoryImpl: PointRepositoryImpl): PointRepository

    @Binds
    @Singleton
    abstract fun bindMultiUseRepository(multiUseRepositoryImpl: MultiUseRepositoryImpl): MultiUseRepository
}
