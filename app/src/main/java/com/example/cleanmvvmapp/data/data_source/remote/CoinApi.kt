package com.example.cleanmvvmapp.data.data_source.remote

import com.example.cleanmvvmapp.domain.model.CoinEntity
import retrofit2.http.GET

interface CoinApi {

    @GET("v1/coins")
    suspend fun getCoinList(): List<CoinEntity>

}