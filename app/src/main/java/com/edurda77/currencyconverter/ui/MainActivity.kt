package com.edurda77.currencyconverter.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.currencyconverter.app
import com.edurda77.currencyconverter.databinding.ActivityMainBinding
import com.edurda77.currencyconverter.domain.CurrencyDao
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import com.edurda77.currencyconverter.model.ConvertorViewModel
import com.edurda77.currencyconverter.model.Currency

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val convertorViewModel = ConvertorViewModel(this)
    private val currentJson: CurrencyUseCase by lazy { app.currencyUseCase }
    private val currentFromDb: CurrencyDao by lazy { app.currencyRepoDbImpl }
    private var currencyes = emptyList<Currency>().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Thread {
            val cashe = currentJson.getCurrenciesSync()
            //val crr = currentFromDb.getCurrenciesT()
            if (cashe != null) {
                /*currencyes.add(Currency(crr.valute.amd.charCode,
                    crr.valute.amd.nominal,
                    crr.valute.amd.name,
                    crr.valute.amd.value ))*/
                currentFromDb.clearAll()

                currentFromDb.add(
                    Currency(
                        cashe.valute.amd.charCode,
                        cashe.valute.amd.nominal,
                        cashe.valute.amd.name,
                        cashe.valute.amd.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.aud.charCode,
                        cashe.valute.aud.nominal,
                        cashe.valute.aud.name,
                        cashe.valute.aud.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.azn.charCode,
                        cashe.valute.azn.nominal,
                        cashe.valute.azn.name,
                        cashe.valute.azn.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.bgn.charCode,
                        cashe.valute.bgn.nominal,
                        cashe.valute.bgn.name,
                        cashe.valute.bgn.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.brl.charCode,
                        cashe.valute.brl.nominal,
                        cashe.valute.brl.name,
                        cashe.valute.brl.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.byn.charCode,
                        cashe.valute.byn.nominal,
                        cashe.valute.byn.name,
                        cashe.valute.byn.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.cad.charCode,
                        cashe.valute.cad.nominal,
                        cashe.valute.cad.name,
                        cashe.valute.cad.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.chf.charCode,
                        cashe.valute.chf.nominal,
                        cashe.valute.chf.name,
                        cashe.valute.chf.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.cny.charCode,
                        cashe.valute.cny.nominal,
                        cashe.valute.cny.name,
                        cashe.valute.cny.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.czk.charCode,
                        cashe.valute.czk.nominal,
                        cashe.valute.czk.name,
                        cashe.valute.czk.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.dkk.charCode,
                        cashe.valute.dkk.nominal,
                        cashe.valute.dkk.name,
                        cashe.valute.dkk.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.eur.charCode,
                        cashe.valute.eur.nominal,
                        cashe.valute.eur.name,
                        cashe.valute.eur.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.gbp.charCode,
                        cashe.valute.gbp.nominal,
                        cashe.valute.gbp.name,
                        cashe.valute.gbp.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.hkd.charCode,
                        cashe.valute.hkd.nominal,
                        cashe.valute.hkd.name,
                        cashe.valute.hkd.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.huf.charCode,
                        cashe.valute.huf.nominal,
                        cashe.valute.huf.name,
                        cashe.valute.huf.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.inr.charCode,
                        cashe.valute.inr.nominal,
                        cashe.valute.inr.name,
                        cashe.valute.inr.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.jpy.charCode,
                        cashe.valute.jpy.nominal,
                        cashe.valute.jpy.name,
                        cashe.valute.jpy.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.kgs.charCode,
                        cashe.valute.kgs.nominal,
                        cashe.valute.kgs.name,
                        cashe.valute.kgs.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.krw.charCode,
                        cashe.valute.krw.nominal,
                        cashe.valute.krw.name,
                        cashe.valute.krw.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.kzt.charCode,
                        cashe.valute.kzt.nominal,
                        cashe.valute.kzt.name,
                        cashe.valute.kzt.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.mdl.charCode,
                        cashe.valute.mdl.nominal,
                        cashe.valute.mdl.name,
                        cashe.valute.mdl.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.nok.charCode,
                        cashe.valute.nok.nominal,
                        cashe.valute.nok.name,
                        cashe.valute.nok.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.pln.charCode,
                        cashe.valute.pln.nominal,
                        cashe.valute.pln.name,
                        cashe.valute.pln.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.ron.charCode,
                        cashe.valute.ron.nominal,
                        cashe.valute.ron.name,
                        cashe.valute.ron.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.sek.charCode,
                        cashe.valute.sek.nominal,
                        cashe.valute.sek.name,
                        cashe.valute.sek.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.sgd.charCode,
                        cashe.valute.sgd.nominal,
                        cashe.valute.sgd.name,
                        cashe.valute.sgd.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.tjs.charCode,
                        cashe.valute.tjs.nominal,
                        cashe.valute.tjs.name,
                        cashe.valute.tjs.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.tmt.charCode,
                        cashe.valute.tmt.nominal,
                        cashe.valute.tmt.name,
                        cashe.valute.tmt.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.tray.charCode,
                        cashe.valute.tray.nominal,
                        cashe.valute.tray.name,
                        cashe.valute.tray.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.uah.charCode,
                        cashe.valute.uah.nominal,
                        cashe.valute.uah.name,
                        cashe.valute.uah.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.usd.charCode,
                        cashe.valute.usd.nominal,
                        cashe.valute.usd.name,
                        cashe.valute.usd.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.uzs.charCode,
                        cashe.valute.uzs.nominal,
                        cashe.valute.uzs.name,
                        cashe.valute.uzs.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.xdr.charCode,
                        cashe.valute.xdr.nominal,
                        cashe.valute.xdr.name,
                        cashe.valute.xdr.value
                    )
                )
                currentFromDb.add(
                    Currency(
                        cashe.valute.zar.charCode,
                        cashe.valute.zar.nominal,
                        cashe.valute.zar.name,
                        cashe.valute.zar.value
                    )
                )

            }
        }.start()
        Thread {
            val ert = currentFromDb.getCurrenciesT()
            ert.forEach {
                currencyes.add(it)
                runOnUiThread {
                    setOotRecycledView()
                }
            }
        }.start()
        //setOotRecycledView()
    }

    private fun setOotRecycledView() {

        val recyclerView: RecyclerView = binding.recycledView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        val stateClickListener: CurrencyAdapter.OnStateClickListener =
            object : CurrencyAdapter.OnStateClickListener {
                override fun onStateClick(currency: Currency, position: Int) {
                    val intent = Intent(this@MainActivity, ConvertorActivity::class.java)
                    intent.putExtra(Currency::class.java.simpleName, currency)

                    startActivity(intent)
                }
            }
        /*val adapter = CurrencyAdapter(currencyes, stateClickListener)
        recyclerView.adapter = adapter
        //convertorViewModel.initData(this)
        convertorViewModel.getGurrences().observe(this) { list ->
            //currencyes.clear()
            *//*list.forEach {
                currencyes.add(it)
            }*//*
            recyclerView.adapter = CurrencyAdapter(list, stateClickListener)
            adapter.notifyDataSetChanged()
        }*/

        recyclerView.adapter = CurrencyAdapter(currencyes, stateClickListener)


    }
}