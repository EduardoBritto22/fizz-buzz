package fr.exaltit.fizz_buzz.domain.utils

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData

/**
 * Class to calculate sequence replacing the multiples by the words.
 */
class FizzBuzzCalculator(private val data: FizzBuzzData) {
	
	fun getFizzBuzzText(): List<String> {
		
		val fizzBuzzList = mutableListOf<String>()
		val fizzBuzzString = StringBuilder("")
		
		data.let {
			for (i in 1..it.limit) {
				
				val fizzbuzzTemp = getTextForMultiple(
					value = i,
					multiple = it.firstMultiple,
					word = it.firstWord
				)
					.plus(
						getTextForMultiple(
							value = i,
							multiple = it.secondMultiple,
							word = it.secondWord
						)
					)
					.ifEmpty { "$i" }
				
				fizzBuzzString.append(if (i == 1L) {
					fizzbuzzTemp
				} else {
					", $fizzbuzzTemp"
					
				})
				if (i >= 10 && (i) % 10 == 0L && fizzBuzzString.isNotEmpty()) {
					fizzBuzzList.add(fizzBuzzString.toString())
					fizzBuzzString.clear()
				}
			}
			if(fizzBuzzString.isNotEmpty()){
				fizzBuzzList.add(fizzBuzzString.toString())
			}
		}
		
		return fizzBuzzList
	}
	
	private fun getTextForMultiple(value: Long, multiple: Long, word: String): String {
		return if (value % multiple == 0L) {
			word
		} else {
			""
		}
	}
}
	
