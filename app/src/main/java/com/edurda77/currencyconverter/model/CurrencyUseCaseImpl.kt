package com.edurda77.currencyconverter.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.edurda77.currencyconverter.domain.CbrApi
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import com.edurda77.currencyconverter.model.Utility.hideProgressBar
import com.edurda77.currencyconverter.model.Utility.showProgressBar
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
    override fun getCurrenciesSync(): DataOfValute? {


        return api.getCurrency().execute().body()
    }

    override fun getCurrenciesAsync(
        onSuccess: (DataOfValute) -> Unit,
        OnError: (Throwable) -> Unit
    ) {
        api.getCurrency().enqueue(object : Callback<DataOfValute> {
            override fun onResponse(call: Call<DataOfValute>, response: Response<DataOfValute>) {
                if (response.isSuccessful) {
                    onSuccess(response.body() ?: throw IllegalStateException("Нулевой результат"))
                } else {
                    OnError(Throwable("Неизвестная ошибка"))
                }

            }
            override fun onFailure(call: Call<DataOfValute>, t: Throwable) {
                OnError(t)
            }
        })
    }
    fun getMutableLiveData(context: Context) : MutableLiveData<DataOfValute> {

        val mutableLiveData = MutableLiveData<DataOfValute>()

        context.showProgressBar()

        api.getCurrency().enqueue(object : Callback<DataOfValute> {
            override fun onFailure(call: Call<DataOfValute>, t: Throwable) {
                hideProgressBar()
                val error = "error" + t.localizedMessage
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<DataOfValute>,
                response: Response<DataOfValute>
            ) {
                hideProgressBar()
                val usersResponse = response.body()
                usersResponse?.let { mutableLiveData.value = it }
            }

        })

        return mutableLiveData
    }
}