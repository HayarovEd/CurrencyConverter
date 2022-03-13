package com.edurda77.currencyconverter.model

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

@SuppressLint("StaticFieldLeak")
object Utility {

    private var progressBar: ProgressBar? = null

    fun Context.isInternetAvailable(): Boolean {
        try {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return if (netInfo != null && netInfo.isConnected) {
                true
            } else {
                showErrorToast("Интернет отсутстсвует")
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun Context.showErrorToast(message: String?) {

        try {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun Context.showProgressBar() {
        try {
            progressBar = ProgressBar(this, null)
            progressBar?.let { it1 ->
                it1.isIndeterminate = true
                it1.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

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