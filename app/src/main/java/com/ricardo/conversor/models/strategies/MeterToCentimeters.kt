package com.ricardo.conversor.models.strategies

class MeterToCentimeters : CalculationStrategy {
    override fun calculate(value: Double): Double = value * 100

    override fun getResultLabel(isPlural: Boolean): String = if(isPlural) "centimetros" else "centimetro"
}