package com.edurda77.currencyconverter.domain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.edurda77.currencyconverter.model.*
@Dao
interface CurrencyDao {
    @Insert
    fun add(currency: Currency)
    @Query("SELECT * FROM $CURRENCY_TABLE")
    fun getCurrencies(): LiveData<List<Currency>>
    @Query(
        "UPDATE $CURRENCY_TABLE " +
                "SET $CURRENCY_NOMINAL=:nominal, " +
                "$CURRENCY_NAME=:name,  " +
                "$CURRENCY_VALUE=:value  " +
                "WHERE $CURRENCY_CHAR_CODE=:charCode"
    )
    fun update(charCode: String, nominal: Int, name: String, value: Double)
}