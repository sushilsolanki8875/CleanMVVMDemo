package com.example.cleanmvvmapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoinEntity(
    @PrimaryKey val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinEntity.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        isActive =  is_active,
        rank = rank,
        symbol = symbol
    )
}