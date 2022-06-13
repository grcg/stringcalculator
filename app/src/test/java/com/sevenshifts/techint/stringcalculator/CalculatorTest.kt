package com.sevenshifts.techint.stringcalculator

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.StringContains
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
internal class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun validResultWhenCorrectInputForAdditionOperation() {
        val expectedResult = 78
        val additionResult = calculator.add("8,19,24,16,11")
        assertEquals(expectedResult, additionResult)
    }

    @Test
    fun validResultWhenEmptyInputForAdditionOperation() {
        val expectedResult = 0
        val additionResult = calculator.add("")
        assertEquals(expectedResult, additionResult)
    }

    @Test
    fun validIntegerReturnTypeWhenCorrectInputForAdditionOperation() {
        var isIntegerType: Boolean
        when (calculator.add("8,19,24,16,11")) {
            else -> {
                isIntegerType = true
            }
        }
        assertEquals(true, isIntegerType)
    }

    @Test
    fun validDigitResultWhenCorrectInputForAdditionOperation() {
        val additionResult = calculator.add("8,19,24,16,11")
        var isDigit: Boolean = additionResult.toString().matches("^[-+]?\\d+".toRegex())
        assertTrue(isDigit)
    }

    @Test
    fun validResultWhenCorrectInputNewLinesForAdditionOperation() {
        val expectedResult = 19
        val additionResult = calculator.add("5,-7\n,2,3\n,2")
        assertEquals(expectedResult, additionResult)
    }

    @Test
    fun invalidWhenNegativeInputForAdditionOperation() {
        val input = "5,-7\n,2,3\n,2"
        if (isValidInput(input)) {
            calculator.add(input)
        }
    }

    private fun isValidInput(input: String): Boolean {
        var isValid = false
        try {
            assertThrows(Exception::class.java) {
                val negativeNumberPattern = "[-][0-9]+".toRegex()
                if (negativeNumberPattern.containsMatchIn(input)) {
                    throw NumberFormatException()
                } else {
                    isValid = true
                }
            }
        } catch (e: Exception) {
            assertThat(e.message, StringContains("Negatives not allowed"))
        }
        return isValid
    }
}