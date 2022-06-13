package com.sevenshifts.techint.stringcalculator

class Calculator {

    fun add(input: String): Int {
        val negativeNumberPattern = "[-][0-9]+".toRegex()
        try {
            if (negativeNumberPattern.containsMatchIn(input)) {
                val matchingCause = negativeNumberPattern.findAll(input)
                var faultyNumber = ""
                matchingCause.iterator().forEach {
                    faultyNumber += "${it.value}, "
                }
                throw NumberFormatException("Negatives not allowed $faultyNumber")
            }
        } catch (e: NumberFormatException) {
            println(e.message)
        }
        val numbers = Regex("[0-9]+").findAll(input)
            .map {
                it.value
            }
            .sumOf {
                it.toInt()
            }
        return numbers
    }

    fun substract(quantity1: Int, quantity2: Int): Int = quantity1 - quantity2

    fun multiply(quantity1: Int, quantity2: Int): Int = quantity1 * quantity2

    fun divide(quantity1: Int, quantity2: Int): Int = quantity1 / quantity2
}
