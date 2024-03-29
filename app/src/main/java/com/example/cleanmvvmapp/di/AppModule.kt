package com.example.cleanmvvmapp.di

import android.content.Context
import androidx.room.Room
import com.example.cleanmvvmapp.utils.Constants
import com.example.cleanmvvmapp.utils.Constants.DB_NAME
import com.example.cleanmvvmapp.data.data_source.remote.CoinApi
import com.example.cleanmvvmapp.data.repository.CoinRepositoryImp
import com.example.cleanmvvmapp.data.data_source.local.CoinAppDatabase
import com.example.cleanmvvmapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesCoinAPIs(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api : CoinApi, database: CoinAppDatabase): CoinRepository{
        return CoinRepositoryImp(api, database.coinDao())
    }

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext applicationContext: Context): CoinAppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            CoinAppDatabase::class.java, DB_NAME
        ).build()
    }

}