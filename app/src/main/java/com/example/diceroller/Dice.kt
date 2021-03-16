package com.example.diceroller

class Dice(private val numSides: Int) {
    val luckyNumber = (1..numSides).random()

    fun roll(): Int {
        return (1..numSides).random()
    }
}