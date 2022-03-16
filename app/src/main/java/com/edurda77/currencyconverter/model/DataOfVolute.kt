package com.edurda77.currencyconverter.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataOfVolute(
    @SerializedName("Date")
    val date: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val valute: Volute
): Serializable
