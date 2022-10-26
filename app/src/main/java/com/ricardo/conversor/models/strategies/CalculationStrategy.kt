package com.ricardo.conversor.models.strategies

import android.icu.text.CurrencyPluralInfo

interface CalculationStrategy {

    fun calculate(value: Double): Double

    fun getResultLabel(isPlural : Boolean) : String
}