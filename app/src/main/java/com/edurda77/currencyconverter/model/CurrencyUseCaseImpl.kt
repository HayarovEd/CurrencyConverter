package com.edurda77.currencyconverter.model

import com.edurda77.currencyconverter.domain.CbrApi
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.cbr-xml-daily.ru/"

class CurrencyUseCaseImpl : CurrencyUseCase {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var api: CbrApi = retrofit.create(CbrApi::class.java)
    override fun getCurrenciesSync(): DataOfValute? {


        return api.getCurrency().execute().body()
    }

}