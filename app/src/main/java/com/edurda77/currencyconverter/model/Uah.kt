package com.edurda77.currencyconverter.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class Uah(
    @SerializedName("CharCode")
    val charCode: String,
    @SerializedName("Nominal")
    val nominal: Int,
    @SerializedName("Name")
    val name:String,
    @SerializedName("Value")
    val value:Double
): Serializable
