package com.edurda77.currencyconverter.domain

import androidx.annotation.WorkerThread
import com.edurda77.currencyconverter.model.DataOfValute

interface CurrencyUseCase {
    @WorkerThread
    @Throws(Throwable::class)
    fun getCurrenciesSync (): DataOfValute?

}