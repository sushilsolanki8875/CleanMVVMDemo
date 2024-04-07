package com.example.cleanmvvmapp.data

import com.example.cleanmvvmapp.domain.model.CoinEntity
import com.example.cleanmvvmapp.domain.repository.CoinRepository

class MockCoinRepositoryImp : CoinRepository {

    //Mocking data...Avoiding hitting actual API while testing
    //as it might be mismatch production report and analytics logs.

    override suspend fun getCoins(): List<CoinEntity> {
        val list = mutableListOf<CoinEntity>()
        for (i in 0..100) {
            val coinEntity = CoinEntity(
                id = i.toString(),
                name = "Test ".plus(i),
                is_active = true,
                is_new = true,
                rank = i,
                symbol = "a",
                type = "test"
            )
            list.add(coinEntity)
        }
        return list
    }
}