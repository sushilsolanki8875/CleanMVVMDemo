package com.example.cleanmvvmapp.domain.usecases

import com.example.cleanmvvmapp.domain.model.CoinEntity
import com.example.cleanmvvmapp.domain.repository.CoinRepository

class MockCoinRepository: CoinRepository {

    private var listOfCoins = mutableListOf(
        CoinEntity("1", true, true, "test", 1, "test", "test")
    )

    private var isErrorCase = false

    override suspend fun getCoins(): List<CoinEntity> {
        if(isErrorCase)
            throw Exception()
        return listOfCoins
    }

    fun setTestErrorCase(isErrorCase: Boolean){
        this.isErrorCase = isErrorCase
    }

    fun clearCoinList(){
        listOfCoins.clear()
    }

}