package com.example.cleanmvvmapp.presentation.coin_list

import com.example.cleanmvvmapp.domain.model.Coin

data class CoinListScreenState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val errorMessage: String = ""
)
