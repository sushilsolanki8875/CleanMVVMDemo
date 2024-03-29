package com.example.cleanmvvmapp.domain.usecases

import com.example.cleanmvvmapp.domain.model.toCoin
import com.example.cleanmvvmapp.domain.model.Coin
import com.example.cleanmvvmapp.domain.repository.CoinRepository
import com.example.cleanmvvmapp.utils.Resource
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): Resource<List<Coin>> {
        return try {
            Resource.Success(coinRepository.getCoins().map { it.toCoin() })
        } catch (exe: Exception) {
            Resource.Error(Throwable(exe))
        }
    }
}