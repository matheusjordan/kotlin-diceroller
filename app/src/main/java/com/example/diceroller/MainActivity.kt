package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.treatButtonClick()
    }

    private fun treatButtonClick() {
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            this.rollDice()
        }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val resultDice1: TextView = findViewById(R.id.resultDice1)
        val resultDice2: TextView = findViewById(R.id.resultDice2)
        val resultDice: TextView = findViewById(R.id.resultDice)

        val dice1Face = dice1.roll()
        val dice2Face = dice2.roll()
        val diceSum = dice1Face + dice2Face

        resultDice1.text = dice1Face.toString()
        resultDice2.text = dice2Face.toString()
        resultDice.text = diceSum.toString()
    }
}