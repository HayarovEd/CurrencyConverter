package com.edurda77.currencyconverter.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ConvertorViewModel(private val context: Context) : ViewModel() {


    fun getCurrencies(): LiveData<List<Currency>> {
        val currentFromDb = CurrencyRepoDbImpl(context)
        return currentFromDb.getCurrencies()
    }




}