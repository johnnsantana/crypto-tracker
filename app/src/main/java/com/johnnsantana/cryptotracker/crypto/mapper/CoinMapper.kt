package com.johnnsantana.cryptotracker.crypto.mapper

import com.johnnsantana.cryptotracker.crypto.data.dto.CoinDto
import com.johnnsantana.cryptotracker.crypto.domain.Coin


fun CoinDto.toCoin(): Coin {
    return Coin(
        id = this.id,
        rank = this.rank,
        name = this.name,
        symbol = this.symbol,
        marketCapUsd = this.marketCapUsd,
        priceUsd = this.priceUsd,
        changePercent24Hr = this.changePercent24Hr
    )
}
