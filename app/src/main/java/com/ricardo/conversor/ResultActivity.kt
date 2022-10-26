package com.ricardo.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ricardo.conversor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getDoubleExtra("RESULT", 0.0)
        val label = intent.getStringExtra("LABEL")


        binding.tvValue.text = result.toString()

        binding.tvValueLabel.text = label


            binding.btnClose.setOnClickListener{
            finish()
        }

    }
}