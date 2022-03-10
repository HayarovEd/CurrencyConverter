package com.edurda77.filmlibrary.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.currencyconverter.model.Currency


class CurrencyAdapter(
    private val list: List<Currency>,
    private val onClickListener: OnStateClickListener
) :
    RecyclerView.Adapter<CurrencyHolder>() {

    interface OnStateClickListener {
        fun onStateClick(currency: Currency, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrencyHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        val currency: Currency = list[position]
        holder.bind(currency)
        holder.itemView.setOnClickListener {
            onClickListener.onStateClick(currency, position)
        }

    }

    override fun getItemCount(): Int = list.size
}

