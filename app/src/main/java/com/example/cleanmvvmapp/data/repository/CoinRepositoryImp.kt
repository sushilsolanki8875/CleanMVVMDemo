package com.example.cleanmvvmapp.data.repository

import com.example.cleanmvvmapp.data.data_source.local.dao.CoinDao
import com.example.cleanmvvmapp.data.data_source.remote.CoinApi
import com.example.cleanmvvmapp.domain.model.CoinEntity
import com.example.cleanmvvmapp.domain.repository.CoinRepository
import com.example.cleanmvvmapp.utils.Constants.COIN_LIMIT
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val apis: CoinApi,
    private val coinDao: CoinDao
): CoinRepository {

    override suspend fun getCoins(): List<CoinEntity> {

        return coinDao.getCoinList(COIN_LIMIT).ifEmpty {
            val list = apis.getCoinList()
            coinDao.insertCoinList(list)
            return list.subList(0, COIN_LIMIT)
        }
    }

}