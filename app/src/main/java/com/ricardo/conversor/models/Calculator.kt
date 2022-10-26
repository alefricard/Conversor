package com.ricardo.conversor.models

import com.ricardo.conversor.models.strategies.CalculationStrategy

object Calculator  {

    private var calculationStrategy: CalculationStrategy? = null

    fun setCalculationStrategy (calculationStrategy: CalculationStrategy) {
        this.calculationStrategy = calculationStrategy
    }

    fun calculate(value: Double) : Double{
        if (calculationStrategy == null)
            throw IllegalAccessException("Calculation Strategy is not set")
        return calculationStrategy!!.calculate(value)
    }
}
