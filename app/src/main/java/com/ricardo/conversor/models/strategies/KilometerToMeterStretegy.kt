package com.ricardo.conversor.models.strategies

class KilometerToMeterStretegy : CalculationStrategy {

    override fun calculate(value: Double): Double {
        return value * 1_000
    }

    override fun getResultLabel(isPlural : Boolean): String = if(isPlural) "metros" else "metro"
}