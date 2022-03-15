package com.edurda77.currencyconverter.domain

import com.edurda77.currencyconverter.model.DataOfVolute
import retrofit2.Call
import retrofit2.http.GET

interface CbrApi {
    @GET("daily_json.js")
    fun getCurrency (): Call<DataOfVolute>
}