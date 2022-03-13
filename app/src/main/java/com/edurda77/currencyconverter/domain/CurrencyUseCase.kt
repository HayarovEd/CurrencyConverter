package com.edurda77.currencyconverter.domain

import android.content.Context
import androidx.annotation.WorkerThread
import com.edurda77.currencyconverter.model.DataOfValute
import javax.security.auth.callback.Callback

interface CurrencyUseCase {
    @WorkerThread
    @Throws(Throwable::class)
    fun getCurrenciesSync(): DataOfValute?
    fun getCurrenciesAsync(
        onSuccess: (DataOfValute?) -> Unit,
        onError: (Throwable) -> Unit
    )

}