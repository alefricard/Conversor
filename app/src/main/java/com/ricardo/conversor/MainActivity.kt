package com.ricardo.conversor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.ricardo.conversor.databinding.ActivityMainBinding
import com.ricardo.conversor.models.CalculationStrategyHolder
import com.ricardo.conversor.models.Calculator
import com.ricardo.conversor.models.strategies.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val supportedCalculationStrategies = arrayOf(
        CalculationStrategyHolder("Quilometro para centimetro", KilometerToCentimeters()),
        CalculationStrategyHolder("Quilometro para metro", KilometerToMeterStretegy()),
        CalculationStrategyHolder("Metro para centimetro", MeterToCentimeters()),
        CalculationStrategyHolder("Metro para quilemetro", MeterToKilometerStrategy())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var value = 0.0
        var position = 0

        savedInstanceState?.let {
            value = it.getDouble("VALUE")
            position = it.getInt("POSITION")
        }

        setUi()
        setActions()

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        try {
            outState.putDouble("VALUE", binding.editValue.toString().toDouble())
        } catch (e: NumberFormatException){

        }
        outState.putInt("POSITION", binding.spConversions.selectedItemPosition)

    }


    private fun setActions() {

        binding.btnConvert.setOnClickListener{

            try {

                val value = binding.editValue.text.toString().toDouble()
                val calculationStrategy = supportedCalculationStrategies[
                    binding.spConversions.selectedItemPosition
                ].calculationStrategy

                Calculator.setCalculationStrategy(calculationStrategy)

                val result = Calculator.calculate(value)
                val label = calculationStrategy.getResultLabel(result != 1.toDouble())

                showResult(result, label)

            }catch (e: NumberFormatException){

                binding.editValue.error = "Valor invalido"
                binding.editValue.requestFocus()

            }


        }
        binding.btnClean.setOnClickListener{
             clean()
        }
    }

    private fun clean() {
        binding.editValue.setText("")
        binding.editValue.error = null

        binding.spConversions.setSelection(0)
    }

    private fun showResult(result: Double, label: String) {

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT", result)
        intent.putExtra("LABEL",label )

        startActivity(intent)

    }

    private fun setUi() {

        val spAdapter = ArrayAdapter(this, R.layout.res_spinner_item, getSpinnerData())
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spConversions.adapter = spAdapter

    }

    private fun getSpinnerData(): MutableList<String> {

        val spinnerData = mutableListOf<String>()

        supportedCalculationStrategies.forEach { spinnerData.add(it.name) }
        return spinnerData
    }
}