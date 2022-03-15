package com.edurda77.currencyconverter.model

import com.edurda77.currencyconverter.domain.ConvertorUseCase

class ConvertorUseCaseImpl:ConvertorUseCase {
    override fun convertToRuble(priceCurrency: Double,
                                countRuble: Double): Double {
        return priceCurrency*countRuble
    }

    override fun convertToCurrency(priceCurrency: Double,
                                   countRuble: Double): Double {
       return countRuble/priceCurrency
    }

    override fun divValueOnNominal(value: Double, nominal: Int): Double {
        return value/nominal
    }


}