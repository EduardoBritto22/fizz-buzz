package fr.exaltit.fizz_buzz.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import fr.exaltit.fizz_buzz.domain.use_cases.CalculateFizzBuzzUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FizzBuzzViewModel @Inject constructor(
	private val calculateFizzBuzz: CalculateFizzBuzzUseCase
) : ViewModel() {
	
	val fizzBuzzString = MutableLiveData<String>()
	
	private var data: FizzBuzzData? = null
	
	fun setFizzBuzzData(firstWord: String, secondWord: String, firstMultiple: Int, secondMultiple: Int, limit: Int) {
		data = FizzBuzzData(
			firstMultiple = firstMultiple,
			secondMultiple = secondMultiple,
			limit = limit,
			firstWord = firstWord,
			secondWord = secondWord
		)
		getFizzBuzzText()
	}
	
	
	private fun getFizzBuzzText() {
		viewModelScope.launch {
			data?.let {
				setLoadState()
				calculateFizzBuzz(it)
					.onSuccess { result ->
						setContentState(result)
					}
					.onFailure {
						setErrorState()
					}
			}
		}
		
	}
	
	private fun setContentState(transactionsResult: String) {
		fizzBuzzString.postValue(transactionsResult)
	}
	
	
	private fun setErrorState() {
		fizzBuzzString.postValue("Error!")

	}
	
	private fun setLoadState() {
		fizzBuzzString.postValue("Charging.....")
		
	}
}