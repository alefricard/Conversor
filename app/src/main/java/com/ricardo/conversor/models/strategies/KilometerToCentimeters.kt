package com.ricardo.conversor.models.strategies

class KilometerToCentimeters : CalculationStrategy {
    override fun calculate(value: Double): Double {
        return value * 100_000
    }

    override fun getResultLabel(isPlural: Boolean): String = if (isPlural) "centimetros" else "centimetro"

}