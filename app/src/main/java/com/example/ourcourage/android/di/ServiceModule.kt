package com.example.ourcourage.android.di

import com.example.ourcourage.android.data.service.AuthService
import com.example.ourcourage.android.data.service.HomeService
import com.example.ourcourage.android.data.service.MultiUseService
import com.example.ourcourage.android.data.service.MyPageService
import com.example.ourcourage.android.data.service.PointService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(SingletonComponent :: class)
@Module
object ServiceModule {

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun provideHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)

    @Singleton
    @Provides
    fun provideMultiUseService(retrofit: Retrofit): MultiUseService =
        retrofit.create(MultiUseService::class.java)

    @Singleton
    @Provides
    fun provideMyPageService(retrofit: Retrofit): MyPageService =
        retrofit.create(MyPageService::class.java)

    @Singleton
    @Provides
    fun providePointService(retrofit: Retrofit): PointService =
        retrofit.create(PointService::class.java)
}