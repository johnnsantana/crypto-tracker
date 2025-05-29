package com.johnnsantana.cryptotracker.crypto.domain

import com.johnnsantana.cryptotracker.core.domain.util.NetworkError
import com.johnnsantana.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}