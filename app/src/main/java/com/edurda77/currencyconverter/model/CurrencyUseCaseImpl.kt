package com.edurda77.currencyconverter.model

import com.edurda77.currencyconverter.domain.CbrApi
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import com.edurda77.currencyconverter.model.Utility.hideProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.cbr-xml-daily.ru/"

class CurrencyUseCaseImpl : CurrencyUseCase {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var api: CbrApi = retrofit.create(CbrApi::class.java)
    override fun getCurrenciesSync(): DataOfVolute? {


        return api.getCurrency().execute().body()
    }

    override fun getCurrenciesAsync(
        onSuccess: (DataOfVolute?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.getCurrency().enqueue(object : Callback<DataOfVolute> {
            override fun onResponse(call: Call<DataOfVolute>, response: Response<DataOfVolute>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()?: throw IllegalStateException("Нет данных"))
                } else {
                    onError(Throwable("Ошибка 404"))
                }
            }

            override fun onFailure(call: Call<DataOfVolute>, t: Throwable) {
                hideProgressBar()
                onError(t)
            }

        })
    }
}

