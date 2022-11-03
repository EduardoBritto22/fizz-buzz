package fr.exaltit.fizz_buzz.domain.utils

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Class to calculate sequence replacing the multiples by the words.
 */
class FizzBuzzCalculator(private val data: FizzBuzzData) {
	
	suspend fun getFizzBuzzText(): String = withContext(Dispatchers.IO) {
		var fizzBuzzString = ""
		data.let {
			for (i in 1..it.limit) {
				
				val fizzbuzzTemp = getTextForMultiple(value = i, multiple = it.firstMultiple, word = it.firstWord)
					.plus(getTextForMultiple(value = i, multiple = it.secondMultiple, word = it.secondWord))
					.ifEmpty { "$i" }
				
				fizzBuzzString += "$fizzbuzzTemp, "
			}
			fizzBuzzString = fizzBuzzString.removeSuffix(", ") // remove the last comma
		}
		
		return@withContext fizzBuzzString
	}
	
	private fun getTextForMultiple(value: Long, multiple: Long, word: String): String {
		return if (value % multiple == 0L) { word } else { "" }
	}
}
	
