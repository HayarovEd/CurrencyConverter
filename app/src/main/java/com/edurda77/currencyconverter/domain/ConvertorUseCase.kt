package com.edurda77.currencyconverter.domain

interface ConvertorUseCase {
    fun convertToRuble(priceCurrency: Double, countRuble: Double): Double
    fun convertToCurrency(priceCurrency: Double, countRuble: Double): Double
    fun divValueOnNominal(value: Double, nominal: Int): Double
}