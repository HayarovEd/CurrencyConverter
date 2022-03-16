package com.edurda77.currencyconverter.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edurda77.currencyconverter.model.Currency

@Database(
    entities = [Currency::class],
    version = 1
)
//@TypeConverters(Currency::class)
abstract class CurrenciesRoomDb : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}