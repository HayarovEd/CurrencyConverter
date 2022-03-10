package com.edurda77.filmlibrary.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.currencyconverter.R
import com.edurda77.currencyconverter.model.Currency

class CurrencyHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_currency, parent, false)) {
    private var nameCurrency: TextView? = null
    private var valueCurrency: TextView? = null
    private var nominalCurrency: TextView? = null


    init {
        nameCurrency = itemView.findViewById(R.id.name_currency)
        valueCurrency = itemView.findViewById(R.id.value_currency)
        nominalCurrency = itemView.findViewById(R.id.nominal_currency)

    }

    @SuppressLint("SetTextI18n")
    fun bind(currency: Currency) {
        nameCurrency?.text = nameCurrency?.text.toString() + currency.name
        valueCurrency?.text = valueCurrency?.text.toString() + currency.value.toString()
        nominalCurrency?.text = nominalCurrency?.text.toString() + currency.nominal


    }

}