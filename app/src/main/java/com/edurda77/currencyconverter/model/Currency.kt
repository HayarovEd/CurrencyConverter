package com.edurda77.currencyconverter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
const val CURRENCY_TABLE = "currencies"
const val CURRENCY_CHAR_CODE = "charCode"
const val CURRENCY_NOMINAL = "nominal"
const val CURRENCY_NAME = "name"
const val CURRENCY_VALUE = "value"
@Entity(tableName = CURRENCY_TABLE)
data class Currency(
    @PrimaryKey
    @SerializedName("CharCode")
    @ColumnInfo(name = CURRENCY_CHAR_CODE)
    val charCode: String,
    @SerializedName("Nominal")
    @ColumnInfo(name = CURRENCY_NOMINAL)
    val nominal: Int,
    @SerializedName("Name")
    @ColumnInfo(name = CURRENCY_NAME)
    val name:String,
    @SerializedName("Value")
    @ColumnInfo(name = CURRENCY_VALUE)
    val value:Double
): Serializable
