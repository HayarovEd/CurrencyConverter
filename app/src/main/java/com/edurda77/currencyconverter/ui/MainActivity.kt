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
import com.edurda77.currencyconverter.model.Currency

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val currentJson: CurrencyUseCase by lazy { app.currencyUseCase }
    private val currentFromDb: CurrencyDao by lazy { app.currencyRepoDbImpl }
    private var currencyes = emptyList<Currency>().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Thread {
            val dataOfValute = currentJson.getCurrenciesSync()
            if (dataOfValute != null) {
                if (currentFromDb.equals(null)) {
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.amd.charCode, dataOfValute.valute.amd.nominal,
                            dataOfValute.valute.amd.name, dataOfValute.valute.amd.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.amd.charCode, dataOfValute.valute.amd.nominal,
                            dataOfValute.valute.amd.name, dataOfValute.valute.amd.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.aud.charCode, dataOfValute.valute.aud.nominal,
                            dataOfValute.valute.aud.name, dataOfValute.valute.aud.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.azn.charCode, dataOfValute.valute.azn.nominal,
                            dataOfValute.valute.azn.name, dataOfValute.valute.azn.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.bgn.charCode, dataOfValute.valute.bgn.nominal,
                            dataOfValute.valute.bgn.name, dataOfValute.valute.bgn.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.brl.charCode, dataOfValute.valute.brl.nominal,
                            dataOfValute.valute.brl.name, dataOfValute.valute.brl.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.byn.charCode, dataOfValute.valute.byn.nominal,
                            dataOfValute.valute.byn.name, dataOfValute.valute.byn.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.cad.charCode, dataOfValute.valute.cad.nominal,
                            dataOfValute.valute.cad.name, dataOfValute.valute.cad.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.chf.charCode, dataOfValute.valute.chf.nominal,
                            dataOfValute.valute.chf.name, dataOfValute.valute.chf.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.cny.charCode, dataOfValute.valute.cny.nominal,
                            dataOfValute.valute.cny.name, dataOfValute.valute.cny.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.czk.charCode, dataOfValute.valute.czk.nominal,
                            dataOfValute.valute.czk.name, dataOfValute.valute.czk.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.dkk.charCode, dataOfValute.valute.dkk.nominal,
                            dataOfValute.valute.dkk.name, dataOfValute.valute.dkk.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.eur.charCode, dataOfValute.valute.eur.nominal,
                            dataOfValute.valute.eur.name, dataOfValute.valute.eur.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.gbp.charCode, dataOfValute.valute.gbp.nominal,
                            dataOfValute.valute.gbp.name, dataOfValute.valute.gbp.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.hkd.charCode, dataOfValute.valute.hkd.nominal,
                            dataOfValute.valute.hkd.name, dataOfValute.valute.hkd.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.huf.charCode, dataOfValute.valute.huf.nominal,
                            dataOfValute.valute.huf.name, dataOfValute.valute.huf.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.inr.charCode, dataOfValute.valute.inr.nominal,
                            dataOfValute.valute.inr.name, dataOfValute.valute.inr.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.jpy.charCode, dataOfValute.valute.jpy.nominal,
                            dataOfValute.valute.jpy.name, dataOfValute.valute.jpy.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.kgs.charCode, dataOfValute.valute.kgs.nominal,
                            dataOfValute.valute.kgs.name, dataOfValute.valute.kgs.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.krw.charCode, dataOfValute.valute.krw.nominal,
                            dataOfValute.valute.krw.name, dataOfValute.valute.krw.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.kzt.charCode, dataOfValute.valute.kzt.nominal,
                            dataOfValute.valute.kzt.name, dataOfValute.valute.kzt.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.mdl.charCode, dataOfValute.valute.mdl.nominal,
                            dataOfValute.valute.mdl.name, dataOfValute.valute.mdl.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.nok.charCode, dataOfValute.valute.nok.nominal,
                            dataOfValute.valute.nok.name, dataOfValute.valute.nok.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.pln.charCode, dataOfValute.valute.pln.nominal,
                            dataOfValute.valute.pln.name, dataOfValute.valute.pln.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.ron.charCode, dataOfValute.valute.ron.nominal,
                            dataOfValute.valute.ron.name, dataOfValute.valute.ron.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.sek.charCode, dataOfValute.valute.sek.nominal,
                            dataOfValute.valute.sek.name, dataOfValute.valute.sek.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.sgd.charCode, dataOfValute.valute.sgd.nominal,
                            dataOfValute.valute.sgd.name, dataOfValute.valute.sgd.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.tjs.charCode, dataOfValute.valute.tjs.nominal,
                            dataOfValute.valute.tjs.name, dataOfValute.valute.tjs.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.tmt.charCode, dataOfValute.valute.tmt.nominal,
                            dataOfValute.valute.tmt.name, dataOfValute.valute.tmt.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.tray.charCode, dataOfValute.valute.tray.nominal,
                            dataOfValute.valute.tray.name, dataOfValute.valute.tray.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.uah.charCode, dataOfValute.valute.uah.nominal,
                            dataOfValute.valute.uah.name, dataOfValute.valute.uah.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.usd.charCode, dataOfValute.valute.usd.nominal,
                            dataOfValute.valute.usd.name, dataOfValute.valute.usd.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.uzs.charCode, dataOfValute.valute.uzs.nominal,
                            dataOfValute.valute.uzs.name, dataOfValute.valute.uzs.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.xdr.charCode, dataOfValute.valute.xdr.nominal,
                            dataOfValute.valute.xdr.name, dataOfValute.valute.xdr.value
                        )
                    )
                    currentFromDb.add(
                        Currency(
                            dataOfValute.valute.zar.charCode, dataOfValute.valute.zar.nominal,
                            dataOfValute.valute.zar.name, dataOfValute.valute.zar.value
                        )
                    )
                } else {
                    currentFromDb.update(
                        dataOfValute.valute.zar.charCode, dataOfValute.valute.zar.nominal,
                        dataOfValute.valute.zar.name, dataOfValute.valute.zar.value
                    )
                    /*runOnUiThread {
                        Toast.makeText(this, "БД не пуста", Toast.LENGTH_SHORT).show()
                    }*/
                }
                currentFromDb.getCurrencies().forEach {
                    currencyes.add(it)
                }
            }
            runOnUiThread {
                setOotRecycledView()

            }

        }.start()

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

        recyclerView.adapter = CurrencyAdapter(currencyes, stateClickListener)


    }
}