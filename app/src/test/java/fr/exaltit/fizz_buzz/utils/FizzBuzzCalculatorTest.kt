package fr.exaltit.fizz_buzz.utils

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import fr.exaltit.fizz_buzz.domain.utils.FizzBuzzCalculator
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FizzBuzzCalculatorTest {
	
	/**
	 * Test the sequence for the nominal data : multiples: 3,5 until 20 for words fizz and buzz.
	 */
	@Test
	fun getFizzBuzzText_When_NominalFizzBuzzData() = runBlocking {
		val data = FizzBuzzData(
			firstMultiple = 3,
			secondMultiple = 5,
			limit = 20,
			firstWord = "fizz",
			secondWord = "buzz"
		)
		
		val fizzbuzzText = FizzBuzzCalculator(data).getFizzBuzzText()
		assertEquals(
			"1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz",
			fizzbuzzText
		)
	}
	
	/**
	 * Test if there is an exception when the first multiple is zero
	 */
	@Test(expected = ArithmeticException::class)
	fun getException_When_FirstMultipleIsZero(): Unit = runBlocking {
		val data = FizzBuzzData(
			firstMultiple = 0,
			secondMultiple = 5,
			limit = 20,
			firstWord = "fizz",
			secondWord = "buzz"
		)
		
		FizzBuzzCalculator(data).getFizzBuzzText()
	}
	
	/**
	 * Test if there is an exception when the second multiple is zero
	 */
	@Test(expected = ArithmeticException::class)
	fun getException_When_SecondMultipleIsZero(): Unit = runBlocking {
		val data = FizzBuzzData(
			firstMultiple = 3,
			secondMultiple = 0,
			limit = 20,
			firstWord = "fizz",
			secondWord = "buzz"
		)
		
		FizzBuzzCalculator(data).getFizzBuzzText()
	}
	
	/**
	 * Test if there is no FizzBuzz text when we have a negative limit
	 */
	@Test
	fun getEmptyText_When_negativeLimit(): Unit = runBlocking {
		val data = FizzBuzzData(
			firstMultiple = 1,
			secondMultiple = 1,
			limit = -1,
			firstWord = "a",
			secondWord = "a"
		)
		
		val fizzBuzz = FizzBuzzCalculator(data).getFizzBuzzText()
		assertTrue(fizzBuzz.isEmpty())
	}
}