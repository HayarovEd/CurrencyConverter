package com.edurda77.currencyconverter.domain

import androidx.annotation.WorkerThread
import com.edurda77.currencyconverter.model.DataOfVolute

interface CurrencyUseCase {
    @WorkerThread
    @Throws(Throwable::class)
    fun getCurrenciesSync(): DataOfVolute?
    fun getCurrenciesAsync(
        onSuccess: (DataOfVolute?) -> Unit,
        onError: (Throwable) -> Unit
    )

}