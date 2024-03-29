package com.example.cleanmvvmapp.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanmvvmapp.domain.model.CoinEntity

@Dao
interface CoinDao {

    @Query("SELECT * FROM CoinEntity limit :limit")
    suspend fun getCoinList(limit: Int) : List<CoinEntity>

    @Insert
    suspend fun insertCoinList(coinEntityList: List<CoinEntity>)

}