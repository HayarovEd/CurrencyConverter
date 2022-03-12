package com.edurda77.currencyconverter

import android.app.Application
import android.content.Context
import com.edurda77.currencyconverter.domain.ConvertorUseCase
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import com.edurda77.currencyconverter.model.ConvertorUseCaseImpl
import com.edurda77.currencyconverter.model.CurrencyUseCaseImpl

class App : Application() {
    val currencyUseCase: CurrencyUseCase by lazy { CurrencyUseCaseImpl() }
    val convertorUseCase: ConvertorUseCase by lazy { ConvertorUseCaseImpl() }


}

val Context.app
    get() = applicationContext as App