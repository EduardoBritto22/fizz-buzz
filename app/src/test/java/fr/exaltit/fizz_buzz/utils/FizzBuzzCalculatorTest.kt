package fr.exaltit.fizz_buzz.utils

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class FizzBuzzCalculatorTest {
	
	/**
	 * Test the sequence for the nominal data : multiples: 3,5 until 20 for words fizz and buzz.
	 */
	@Test
	fun getFizzBuzzText_When_NominalFizzBuzzData() = runBlocking{
		val data = FizzBuzzData(
			firstMultiple = 3,
			secondMultiple = 5,
			limit = 20,
			firstWord = "fizz",
			secondWord = "buzz"
		)

			val fizzbuzzText = FizzBuzzCalculator(data).getFizzBuzzText()
			assertEquals("1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz, 16, 17, fizz, 19, buzz",fizzbuzzText)
		
		
	}
}