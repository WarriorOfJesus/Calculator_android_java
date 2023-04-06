package com.example.calculator

import kotlin.math.pow

class calculator : Multiplication, Addition, Exponentiation, Divide, Subtraction, Percent {
    var firstNumber = ""
        private set
    var secondNumber = ""
        private set
    private var result = 0.0
    var operation1 = '\u0000'
        private set

    private val story = ArrayList<java.lang.StringBuilder>()

    fun getStory(): String {
        return story.toString()
    }

    fun clearStory() {
        story.clear()
    }

    fun setValue(number: String, operation: Char?) {
        if (operation != null) {
            operation1 = operation
            return
        }
        if (number != "") {
            if (operation1 == '\u0000') {
                firstNumber += number
            } else secondNumber += number
        }

    }


    fun getDisplayText(): String {
        val stringBuilder = StringBuilder()
        if (firstNumber.isNotEmpty()) stringBuilder.append(firstNumber)
        if (!stringBuilder.contains(operation1)) stringBuilder.append(operation1)
        if (secondNumber.isNotEmpty()) stringBuilder.append(secondNumber)
        story.add(stringBuilder)
        return stringBuilder.toString()

    }

    fun delete() {
        if (secondNumber.isNotEmpty()) {
            secondNumber = secondNumber.substring(0, secondNumber.length - 1)
            return
        }
        if (operation1 != '\u0000') {
            operation1 = '\u0000'
            return
        }
        if (firstNumber.isNotEmpty()) {
            firstNumber = firstNumber.substring(0, firstNumber.length - 1)
        }
    }

    fun deleteAll() {
        firstNumber = ""
        secondNumber = ""
        operation1 = '\u0000'
        result = 0.0
    }

    override fun add(num1: Double, num2: Double): String {
        result = num1 + num2
        return result.toString()
    }

    override fun divide(num1: Double, num2: Double): String {
        result = num1 / num2
        return result.toString()
    }

    override fun exponentiation(num1: Double, num2: Double): String {
        result = num1.pow(num2)
        return result.toString()
    }

    override fun multiple(num1: Double, num2: Double): String {
        result = num1 * num2
        return result.toString()
    }

    override fun subtract(num1: Double, num2: Double): String {
        result = num1 - num2
        return result.toString()
    }

    override fun calculatePercent(num1: Double?, num2: Double?): String {
        if (num1 != null) {
            result = num1 / 100 * num2!!
        }
        return result.toString()
    }

    fun equal(secondOperation: Char = '\u0000') {
        if (firstNumber.isEmpty() ||
            operation1 == '\u0000' ||
            secondNumber.isEmpty()
        ) return

        val num1: Double = firstNumber.toDouble()
        val num2: Double = secondNumber.toDouble()
        when (operation1) {
            '+' -> add(num1, num2)
            '-' -> subtract(num1, num2)
            '÷' -> divide(num1, num2)
            '×' -> multiple(num1, num2)
            '^' -> exponentiation(num1, num2)
            '%' -> calculatePercent(num1, num2)
        }
        showResult(secondOperation)
    }

    private fun showResult(secondOperation: Char) {
        firstNumber = "$result"
        secondNumber = ""
        operation1 = secondOperation
        result = 0.0
    }

}