package com.edurda77.currencyconverter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edurda77.currencyconverter.app
import com.edurda77.currencyconverter.databinding.ActivityConvertorBinding
import com.edurda77.currencyconverter.domain.ConvertorUseCase
import com.edurda77.currencyconverter.model.Currency

class ConvertorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConvertorBinding

    private val convertCurrency: ConvertorUseCase by lazy { app.convertorUseCase }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConvertorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val nameCurrency = binding.convertorNameCurrency
        val convertorPrice1 = binding.convertorPrice
        val countRubl1 = binding.convertorCountRubl
        val resultCurrencyToRubl = binding.convertorResult1
        val countRubl2 = binding.convertorRublCount
        val convertorPrice2 = binding.convertorCourse
        val resultRublToCurrency = binding.convertorResult2
        val buttonCurrencyToRubl = binding.convertorCalc1
        val buttonRublToCurrency = binding.convertorCalc2
        val arguments = intent.extras

        if (arguments != null) {
            val currency = arguments.getSerializable(Currency::class.java.simpleName) as Currency
            nameCurrency.text=currency.name
            val price = convertCurrency
                .divValueOnNominal(currency.value, currency.nominal)
            convertorPrice1.text = price.toString()
            convertorPrice2.text = price.toString()
            buttonCurrencyToRubl.setOnClickListener {
                val count = countRubl1.text.toString().toDouble()
                resultCurrencyToRubl.text = convertCurrency
                    .convertToRubl(price, count)
                    .toString()
            }
            buttonRublToCurrency.setOnClickListener {
                val count = countRubl2.text.toString().toDouble()
                resultRublToCurrency.text = convertCurrency
                    .convertToCurrency(price, count)
                    .toString()
            }
        }
    }
}