package com.johnnsantana.cryptotracker.crypto.data

import com.johnnsantana.cryptotracker.core.data.networking.constructUrl
import com.johnnsantana.cryptotracker.core.data.networking.safeCall
import com.johnnsantana.cryptotracker.core.domain.util.NetworkError
import com.johnnsantana.cryptotracker.core.domain.util.Result
import com.johnnsantana.cryptotracker.core.domain.util.map
import com.johnnsantana.cryptotracker.crypto.data.dto.CoinsResponseDto
import com.johnnsantana.cryptotracker.crypto.domain.Coin
import com.johnnsantana.cryptotracker.crypto.domain.CoinDataSource
import com.johnnsantana.cryptotracker.crypto.mapper.toCoin
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }

        }
    }
}