package com.edurda77.currencyconverter.model

import com.edurda77.currencyconverter.domain.ConvertorUseCase

class ConvertorUseCaseImpl:ConvertorUseCase {
    override fun convertToRubl(priceCorrency: Double,
                               countRubl: Double): Double {
        return priceCorrency*countRubl
    }

    override fun convertToCurrency(priceCorrency: Double,
                                   countRubl: Double): Double {
       return countRubl/priceCorrency
    }

    override fun divValueOnNominal(value: Double, nominal: Int): Double {
        return value/nominal
    }


}