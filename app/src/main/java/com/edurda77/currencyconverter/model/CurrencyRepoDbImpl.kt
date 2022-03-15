package com.edurda77.currencyconverter.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.edurda77.currencyconverter.domain.CurrenciesRoomDb
import com.edurda77.currencyconverter.domain.CurrencyDao

private const val DB_PATH = "currencies.db"

class CurrencyRepoDbImpl(context: Context) : CurrencyDao {

    private val currencyDao = Room.databaseBuilder(
        context,
        CurrenciesRoomDb::class.java,
        DB_PATH
    ).build().currencyDao()

    override fun add(currency: Currency) {
        currencyDao.add(currency)
    }

    override fun getCurrencies(): LiveData<List<Currency>> {
        return currencyDao.getCurrencies()
    }

    override fun getCurrenciesT(): List<Currency> {
        return currencyDao.getCurrenciesT()
    }

    override fun update(charCode: String, nominal: Int, name: String, value: Double) {
        currencyDao.update(charCode,nominal,name,value)
    }

    override fun clearAll() {
        currencyDao.clearAll()
    }
}