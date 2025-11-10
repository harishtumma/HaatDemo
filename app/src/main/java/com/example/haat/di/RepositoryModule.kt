package com.example.haat.di

import com.example.haat.data.reposiotry.HomeRepositoryImpl
import com.example.haat.data.reposiotry.VenuInfoRepositoryImpl
import com.example.haat.data.reposiotry.VenuMenuRepositoryImpl
import com.example.haat.domain.repository.HomeRepository
import com.example.haat.domain.repository.VenuInfoRepository
import com.example.haat.domain.repository.VenuMenuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindHomeRepository(bindHomeRepository: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun bindVenuInfoRepository(bindVenuInfoRepository: VenuInfoRepositoryImpl): VenuInfoRepository

    @Binds
    abstract fun bindVenuMenuRepository(bindVenuMenuRepository: VenuMenuRepositoryImpl): VenuMenuRepository
}