package com.example.cleanmvvmapp.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanmvvmapp.data.data_source.local.dao.CoinDao
import com.example.cleanmvvmapp.domain.model.CoinEntity
import com.example.cleanmvvmapp.utils.Constants.DB_VERSION_NO

@Database(entities = [CoinEntity::class], version = DB_VERSION_NO)
abstract class CoinAppDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

}