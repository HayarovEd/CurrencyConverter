package com.edurda77.currencyconverter.model

import android.annotation.SuppressLint
import android.view.View
import android.widget.ProgressBar

@SuppressLint("StaticFieldLeak")
object Utility {

    private var progressBar: ProgressBar? = null

    fun hideProgressBar() {
        try {
            progressBar?.let {
                it.visibility = View.GONE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}