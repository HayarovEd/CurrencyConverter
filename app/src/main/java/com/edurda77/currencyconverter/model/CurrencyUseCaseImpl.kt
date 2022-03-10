package com.edurda77.currencyconverter.model

import com.edurda77.currencyconverter.domain.CbrApi
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.cbr-xml-daily.ru/"

class CurrencyUseCaseImpl : CurrencyUseCase {
    val currencyes: MutableList<Currency> = mutableListOf()
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private var api: CbrApi = retrofit.create(CbrApi::class.java)
    override fun getCurrenciesSync(): List<Currency> {
        val dataOfValute: DataOfValute? = api.getCurrency().execute().body()
        if (dataOfValute != null) {
            convertFormatJson(dataOfValute)
        }
        return currencyes
    }

    private fun convertFormatJson(dataOfValute: DataOfValute): List<Currency> {

        currencyes.add(
            Currency(
                dataOfValute.valute.amd.charCode, dataOfValute.valute.amd.nominal,
                dataOfValute.valute.amd.name, dataOfValute.valute.amd.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.aud.charCode, dataOfValute.valute.aud.nominal,
                dataOfValute.valute.aud.name, dataOfValute.valute.aud.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.azn.charCode, dataOfValute.valute.azn.nominal,
                dataOfValute.valute.azn.name, dataOfValute.valute.azn.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.bgn.charCode, dataOfValute.valute.bgn.nominal,
                dataOfValute.valute.bgn.name, dataOfValute.valute.bgn.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.brl.charCode, dataOfValute.valute.brl.nominal,
                dataOfValute.valute.brl.name, dataOfValute.valute.brl.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.byn.charCode, dataOfValute.valute.byn.nominal,
                dataOfValute.valute.byn.name, dataOfValute.valute.byn.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.cad.charCode, dataOfValute.valute.cad.nominal,
                dataOfValute.valute.cad.name, dataOfValute.valute.cad.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.chf.charCode, dataOfValute.valute.chf.nominal,
                dataOfValute.valute.chf.name, dataOfValute.valute.chf.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.cny.charCode, dataOfValute.valute.cny.nominal,
                dataOfValute.valute.cny.name, dataOfValute.valute.cny.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.czk.charCode, dataOfValute.valute.czk.nominal,
                dataOfValute.valute.czk.name, dataOfValute.valute.czk.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.dkk.charCode, dataOfValute.valute.dkk.nominal,
                dataOfValute.valute.dkk.name, dataOfValute.valute.dkk.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.eur.charCode, dataOfValute.valute.eur.nominal,
                dataOfValute.valute.eur.name, dataOfValute.valute.eur.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.gbr.charCode, dataOfValute.valute.gbr.nominal,
                dataOfValute.valute.gbr.name, dataOfValute.valute.gbr.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.hkd.charCode, dataOfValute.valute.hkd.nominal,
                dataOfValute.valute.hkd.name, dataOfValute.valute.hkd.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.huf.charCode, dataOfValute.valute.huf.nominal,
                dataOfValute.valute.huf.name, dataOfValute.valute.huf.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.inr.charCode, dataOfValute.valute.inr.nominal,
                dataOfValute.valute.inr.name, dataOfValute.valute.inr.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.jpy.charCode, dataOfValute.valute.jpy.nominal,
                dataOfValute.valute.jpy.name, dataOfValute.valute.jpy.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.kgs.charCode, dataOfValute.valute.kgs.nominal,
                dataOfValute.valute.kgs.name, dataOfValute.valute.kgs.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.krw.charCode, dataOfValute.valute.krw.nominal,
                dataOfValute.valute.krw.name, dataOfValute.valute.krw.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.kzt.charCode, dataOfValute.valute.kzt.nominal,
                dataOfValute.valute.kzt.name, dataOfValute.valute.kzt.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.mdl.charCode, dataOfValute.valute.mdl.nominal,
                dataOfValute.valute.mdl.name, dataOfValute.valute.mdl.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.nok.charCode, dataOfValute.valute.nok.nominal,
                dataOfValute.valute.nok.name, dataOfValute.valute.nok.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.pln.charCode, dataOfValute.valute.pln.nominal,
                dataOfValute.valute.pln.name, dataOfValute.valute.pln.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.ron.charCode, dataOfValute.valute.ron.nominal,
                dataOfValute.valute.ron.name, dataOfValute.valute.ron.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.sek.charCode, dataOfValute.valute.sek.nominal,
                dataOfValute.valute.sek.name, dataOfValute.valute.sek.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.sgd.charCode, dataOfValute.valute.sgd.nominal,
                dataOfValute.valute.sgd.name, dataOfValute.valute.sgd.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.tjs.charCode, dataOfValute.valute.tjs.nominal,
                dataOfValute.valute.tjs.name, dataOfValute.valute.tjs.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.tmt.charCode, dataOfValute.valute.tmt.nominal,
                dataOfValute.valute.tmt.name, dataOfValute.valute.tmt.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.tray.charCode, dataOfValute.valute.tray.nominal,
                dataOfValute.valute.tray.name, dataOfValute.valute.tray.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.uah.charCode, dataOfValute.valute.uah.nominal,
                dataOfValute.valute.uah.name, dataOfValute.valute.uah.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.usd.charCode, dataOfValute.valute.usd.nominal,
                dataOfValute.valute.usd.name, dataOfValute.valute.usd.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.uzs.charCode, dataOfValute.valute.uzs.nominal,
                dataOfValute.valute.uzs.name, dataOfValute.valute.uzs.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.xdr.charCode, dataOfValute.valute.xdr.nominal,
                dataOfValute.valute.xdr.name, dataOfValute.valute.xdr.value
            )
        )
        currencyes.add(
            Currency(
                dataOfValute.valute.zar.charCode, dataOfValute.valute.zar.nominal,
                dataOfValute.valute.zar.name, dataOfValute.valute.zar.value
            )
        )
        return currencyes
    }
}