package com.edurda77.currencyconverter.domain

interface ConvertorUseCase {
    fun convertToRubl(priceCorrency: Double, countRubl: Double): Double
    fun convertToCurrency(priceCorrency: Double, countRubl: Double): Double
    fun divValueOnNominal(value: Double, nominal: Int): Double
}