package com.edurda77.currencyconverter.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Volute(
    @SerializedName("AMD")
    val amd: Amd,
    @SerializedName("AUD")
    val aud: Aud,
    @SerializedName("AZN")
    val azn: Azn,
    @SerializedName("BGN")
    val bgn: Bgn,
    @SerializedName("BRL")
    val brl: Brl,
    @SerializedName("BYN")
    val byn: Byn,
    @SerializedName("CAD")
    val cad: Cad,
    @SerializedName("CHF")
    val chf: Chf,
    @SerializedName("CNY")
    val cny: Cny,
    @SerializedName("CZK")
    val czk: Czk,
    @SerializedName("DKK")
    val dkk: Dkk,
    @SerializedName("EUR")
    val eur: Eur,
    @SerializedName("GBP")
    val gbp: Gbp,
    @SerializedName("HKD")
    val hkd: Hkd,
    @SerializedName("HUF")
    val huf: Huf,
    @SerializedName("INR")
    val inr: Inr,
    @SerializedName("JPY")
    val jpy: Jpy,
    @SerializedName("KGS")
    val kgs: Kgs,
    @SerializedName("KRW")
    val krw: Krw,
    @SerializedName("KZT")
    val kzt: Kzt,
    @SerializedName("MDL")
    val mdl: Mdl,
    @SerializedName("NOK")
    val nok: Nok,
    @SerializedName("PLN")
    val pln: Pln,
    @SerializedName("RON")
    val ron: Ron,
    @SerializedName("SEK")
    val sek: Sek,
    @SerializedName("SGD")
    val sgd: Sgd,
    @SerializedName("TJS")
    val tjs: Tjs,
    @SerializedName("TMT")
    val tmt: Tmt,
    @SerializedName("TRY")
    val tray: Try,
    @SerializedName("UAH")
    val uah: Uah,
    @SerializedName("USD")
    val usd: Usd,
    @SerializedName("UZS")
    val uzs: Uzs,
    @SerializedName("XDR")
    val xdr: Xdr,
    @SerializedName("ZAR")
    val zar: Zar
) : Serializable
