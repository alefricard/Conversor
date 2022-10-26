package com.ricardo.conversor.models

import com.ricardo.conversor.models.strategies.CalculationStrategy

data class CalculationStrategyHolder (
    val name : String,
    val calculationStrategy: CalculationStrategy
    )