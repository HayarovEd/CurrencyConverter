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
        val countRuble1 = binding.convertorCountRubl
        val resultCurrencyToRuble = binding.convertorResult1
        val countRuble2 = binding.convertorRublCount
        val convertorPrice2 = binding.convertorCourse
        val resultRubleToCurrency = binding.convertorResult2
        val buttonCurrencyToRuble = binding.convertorCalc1
        val buttonRubleToCurrency = binding.convertorCalc2
        val arguments = intent.extras

        if (arguments != null) {
            val currency = arguments.getSerializable(Currency::class.java.simpleName) as Currency
            nameCurrency.text=currency.name
            val price = convertCurrency
                .divValueOnNominal(currency.value, currency.nominal)
            convertorPrice1.text = price.toString()
            convertorPrice2.text = price.toString()
            buttonCurrencyToRuble.setOnClickListener {
                val count = countRuble1.text.toString().toDouble()
                resultCurrencyToRuble.text = convertCurrency
                    .convertToRuble(price, count)
                    .toString()
            }
            buttonRubleToCurrency.setOnClickListener {
                val count = countRuble2.text.toString().toDouble()
                resultRubleToCurrency.text = convertCurrency
                    .convertToCurrency(price, count)
                    .toString()
            }
        }
    }
}