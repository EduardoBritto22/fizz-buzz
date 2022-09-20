package fr.exaltit.fizz_buzz.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FizzBuzzViewModel @Inject constructor(
): ViewModel() {

	var firstMultiple = 1
	var secondMultiple = 2
	var limit = 20
	
	var firstWord = "Fizz"
	var secondWord = "Buzz"
	
}