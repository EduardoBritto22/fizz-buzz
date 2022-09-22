package fr.exaltit.fizz_buzz.utils

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData

class FizzBuzzCalculator(private val data: FizzBuzzData) {
	
	fun getFizzBuzzText():String{
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
		
		return fizzBuzzString
	}
}
	
