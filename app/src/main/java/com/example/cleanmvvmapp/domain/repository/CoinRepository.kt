package com.example.cleanmvvmapp.domain.repository

import com.example.cleanmvvmapp.domain.model.CoinEntity

interface CoinRepository {

    suspend fun getCoins(): List<CoinEntity>

}