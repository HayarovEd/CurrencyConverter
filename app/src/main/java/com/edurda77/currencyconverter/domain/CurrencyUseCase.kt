package com.edurda77.currencyconverter.domain

import androidx.annotation.WorkerThread
import com.edurda77.currencyconverter.model.Currency

interface CurrencyUseCase {
    @WorkerThread
    @Throws(Throwable::class)
    fun getCurrenciesSync (): List<Currency>?

}