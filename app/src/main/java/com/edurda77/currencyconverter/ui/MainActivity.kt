package com.edurda77.currencyconverter.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.currencyconverter.app
import com.edurda77.currencyconverter.databinding.ActivityMainBinding
import com.edurda77.currencyconverter.domain.CurrencyDao
import com.edurda77.currencyconverter.domain.CurrencyUseCase
import com.edurda77.currencyconverter.model.ConvertorViewModel
import com.edurda77.currencyconverter.model.Currency
import com.edurda77.currencyconverter.model.DataOfVolute
import java.lang.Thread.sleep
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val convertorViewModel = ConvertorViewModel(this)
    private val currentJson: CurrencyUseCase by lazy { app.currencyUseCase }
    private val currentFromDb: CurrencyDao by lazy { app.currencyRepoDbImpl }
    private var currencies = emptyList<Currency>().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val timeOfLoad = binding.timeOfLoad
        val updateButton = binding.newCourse

        updateButton.setOnClickListener {
            updateData()

        }
        Thread {
            val cache = currentJson.getCurrenciesSync()
            if (cache != null) {
                runOnUiThread {
                    timeOfLoad.text = cache.date
                }
                if (currentFromDb.equals(null)) {
                    addData(cache)
                }
            }
        }.start()

        setOotRecycledView()
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
        val adapter = CurrencyAdapter(currencies, stateClickListener)
        recyclerView.adapter = adapter //convertorViewModel.initData(this)
        convertorViewModel.getCurrencies().observe(this) { list ->

            recyclerView.adapter = CurrencyAdapter(list, stateClickListener)
            adapter.notifyDataSetChanged()
        }
    }

    private fun addData(cache: DataOfVolute) {
        currentFromDb.add(
            Currency(
                cache.valute.amd.charCode,
                cache.valute.amd.nominal,
                cache.valute.amd.name,
                cache.valute.amd.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.aud.charCode,
                cache.valute.aud.nominal,
                cache.valute.aud.name,
                cache.valute.aud.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.azn.charCode,
                cache.valute.azn.nominal,
                cache.valute.azn.name,
                cache.valute.azn.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.bgn.charCode,
                cache.valute.bgn.nominal,
                cache.valute.bgn.name,
                cache.valute.bgn.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.brl.charCode,
                cache.valute.brl.nominal,
                cache.valute.brl.name,
                cache.valute.brl.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.byn.charCode,
                cache.valute.byn.nominal,
                cache.valute.byn.name,
                cache.valute.byn.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.cad.charCode,
                cache.valute.cad.nominal,
                cache.valute.cad.name,
                cache.valute.cad.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.chf.charCode,
                cache.valute.chf.nominal,
                cache.valute.chf.name,
                cache.valute.chf.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.cny.charCode,
                cache.valute.cny.nominal,
                cache.valute.cny.name,
                cache.valute.cny.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.czk.charCode,
                cache.valute.czk.nominal,
                cache.valute.czk.name,
                cache.valute.czk.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.dkk.charCode,
                cache.valute.dkk.nominal,
                cache.valute.dkk.name,
                cache.valute.dkk.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.eur.charCode,
                cache.valute.eur.nominal,
                cache.valute.eur.name,
                cache.valute.eur.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.gbp.charCode,
                cache.valute.gbp.nominal,
                cache.valute.gbp.name,
                cache.valute.gbp.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.hkd.charCode,
                cache.valute.hkd.nominal,
                cache.valute.hkd.name,
                cache.valute.hkd.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.huf.charCode,
                cache.valute.huf.nominal,
                cache.valute.huf.name,
                cache.valute.huf.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.inr.charCode,
                cache.valute.inr.nominal,
                cache.valute.inr.name,
                cache.valute.inr.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.jpy.charCode,
                cache.valute.jpy.nominal,
                cache.valute.jpy.name,
                cache.valute.jpy.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.kgs.charCode,
                cache.valute.kgs.nominal,
                cache.valute.kgs.name,
                cache.valute.kgs.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.krw.charCode,
                cache.valute.krw.nominal,
                cache.valute.krw.name,
                cache.valute.krw.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.kzt.charCode,
                cache.valute.kzt.nominal,
                cache.valute.kzt.name,
                cache.valute.kzt.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.mdl.charCode,
                cache.valute.mdl.nominal,
                cache.valute.mdl.name,
                cache.valute.mdl.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.nok.charCode,
                cache.valute.nok.nominal,
                cache.valute.nok.name,
                cache.valute.nok.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.pln.charCode,
                cache.valute.pln.nominal,
                cache.valute.pln.name,
                cache.valute.pln.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.ron.charCode,
                cache.valute.ron.nominal,
                cache.valute.ron.name,
                cache.valute.ron.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.sek.charCode,
                cache.valute.sek.nominal,
                cache.valute.sek.name,
                cache.valute.sek.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.sgd.charCode,
                cache.valute.sgd.nominal,
                cache.valute.sgd.name,
                cache.valute.sgd.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.tjs.charCode,
                cache.valute.tjs.nominal,
                cache.valute.tjs.name,
                cache.valute.tjs.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.tmt.charCode,
                cache.valute.tmt.nominal,
                cache.valute.tmt.name,
                cache.valute.tmt.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.tray.charCode,
                cache.valute.tray.nominal,
                cache.valute.tray.name,
                cache.valute.tray.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.uah.charCode,
                cache.valute.uah.nominal,
                cache.valute.uah.name,
                cache.valute.uah.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.usd.charCode,
                cache.valute.usd.nominal,
                cache.valute.usd.name,
                cache.valute.usd.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.uzs.charCode,
                cache.valute.uzs.nominal,
                cache.valute.uzs.name,
                cache.valute.uzs.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.xdr.charCode,
                cache.valute.xdr.nominal,
                cache.valute.xdr.name,
                cache.valute.xdr.value
            )
        )
        currentFromDb.add(
            Currency(
                cache.valute.zar.charCode,
                cache.valute.zar.nominal,
                cache.valute.zar.name,
                cache.valute.zar.value
            )
        )
    }

    private fun updateData() {
        Thread {
            currentFromDb.clearAll()
            val cache = currentJson.getCurrenciesSync()
            if (cache != null) {
                runOnUiThread {
                    binding.timeOfLoad.text = cache.date
                    Toast.makeText(this, "Данные обновлены", Toast.LENGTH_SHORT).show()
                }
                addData(cache)
            }
        }.start()

    }

}