package fr.exaltit.fizz_buzz.utils

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Class to calculate sequence replacing the multiples by the words.
 */
class FizzBuzzCalculator(private val data: FizzBuzzData) {
	
	suspend fun getFizzBuzzText():String = withContext(Dispatchers.IO){
		var fizzBuzzString = ""
		data.let {
			for(i in 1 .. it.limit){
				fizzBuzzString += if(i%it.firstMultiple==0 && i%it.secondMultiple==0){
					"${it.firstWord }${it.secondWord }, "
				} else if (i%it.firstMultiple==0){
					"${it.firstWord}, "
				} else if(i%it.secondMultiple==0){
					"${it.secondWord}, "
				} else {
					"$i, "
				}
			}
			fizzBuzzString = fizzBuzzString.removeSuffix(", ") // remove the last comma
		}
		
		return@withContext fizzBuzzString
	}
}
	
