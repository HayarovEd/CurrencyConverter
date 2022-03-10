package com.edurda77.currencyconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.currencyconverter.databinding.ActivityConvertorBinding
import com.edurda77.currencyconverter.databinding.ActivityMainBinding

class ConvertorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConvertorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConvertorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}