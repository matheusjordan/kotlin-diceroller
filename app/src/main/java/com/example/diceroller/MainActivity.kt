package com.example.diceroller

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        val resultLucky1: TextView = findViewById(R.id.luckyResult1)
        val resultLucky2: TextView = findViewById(R.id.luckyResult2)

        val dice1LuckyNumber = dice1.luckyNumber
        val dice2LuckyNumber = dice2.luckyNumber

        resultLucky1.text = dice1LuckyNumber.toString()
        resultLucky2.text = dice2LuckyNumber.toString()

        val fullLucky = (dice1Face ==  dice1LuckyNumber) && (dice2Face == dice2LuckyNumber)
        val halfLucky = (dice1Face ==  dice1LuckyNumber) || (dice2Face == dice2LuckyNumber)
        val noneLucky = (dice1Face !=  dice1LuckyNumber) || (dice2Face != dice2LuckyNumber)

        val resultLuckyText: TextView = findViewById(R.id.luckyText)

        val luckyText = when(true) {
            fullLucky -> {
                resultLuckyText.setTextColor(Color.MAGENTA)
                "Are you very lucky today! :D"
            }
            halfLucky -> {
                resultLuckyText.setTextColor(Color.GREEN)
                "Are you a bit lucky! :)"
            }
            noneLucky -> {
                resultLuckyText.setTextColor(Color.BLACK)
                "Nothing for today :/"
            }
            else -> {
                resultLuckyText.setTextColor(Color.RED)
                "oh man... !!! :'C"
            }
        }

        resultLuckyText.text = luckyText

        val dice1Thumbnail: ImageView = findViewById(R.id.face1Thumbnail)
        val dice2Thumbnail: ImageView = findViewById(R.id.face2Thumbnail)

        this.setDiceThumbnail(dice1Face, dice1Thumbnail)
        this.setDiceThumbnail(dice2Face, dice2Thumbnail)
    }

    private fun setDiceThumbnail(diceNumber: Int, imageView: ImageView) {
        val drawable = when (diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageView.setImageResource(drawable)
    }
}