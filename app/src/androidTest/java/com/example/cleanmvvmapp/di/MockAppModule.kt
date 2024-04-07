package com.example.cleanmvvmapp.di

import com.example.cleanmvvmapp.data.MockCoinRepositoryImp
import com.example.cleanmvvmapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MockAppModule {


    @Provides
    @Singleton
    fun providesCoinRepository(): CoinRepository {
        return MockCoinRepositoryImp()
    }


}