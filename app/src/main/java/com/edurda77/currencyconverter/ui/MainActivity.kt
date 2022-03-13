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
       // convertorViewModel.initData()
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
        val adapter = CurrencyAdapter(currencyes, stateClickListener)
        recyclerView.adapter = adapter
        //convertorViewModel.initData(this)
        convertorViewModel.getGurrences().observe(this) { list ->
            //currencyes.clear()
            /*list.forEach {
                currencyes.add(it)
            }*/
            recyclerView.adapter = CurrencyAdapter(list, stateClickListener)
            adapter.notifyDataSetChanged()
        }

        //recyclerView.adapter = CurrencyAdapter(currencyes, stateClickListener)


    }
}