package com.example.cleanmvvmapp.presentation.utils

sealed class Screens(val route: String) {
    data object CoinListScreen: Screens("coin_list_screen")
}