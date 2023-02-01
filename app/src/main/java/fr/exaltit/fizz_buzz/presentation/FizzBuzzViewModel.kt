package fr.exaltit.fizz_buzz.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import fr.exaltit.fizz_buzz.domain.use_cases.CalculateFizzBuzzUseCase
import javax.inject.Inject

@HiltViewModel
class FizzBuzzViewModel @Inject constructor(
	private val calculateFizzBuzz: CalculateFizzBuzzUseCase
) : ViewModel() {
	
	val fizzBuzzString = MutableLiveData<String>()
	val showNextFragment = MutableLiveData<Boolean>()
	
	private var data: FizzBuzzData? = null
	
	init {
		showNextFragment.postValue(false)
	}
	
	fun setFizzBuzzData(firstWord: String, secondWord: String, firstMultiple: Long, secondMultiple: Long, limit: Long) {
		data = FizzBuzzData(
			firstMultiple = firstMultiple,
			secondMultiple = secondMultiple,
			limit = limit,
			firstWord = firstWord,
			secondWord = secondWord
		)
	}
	
	fun showNextFragment( showNext: Boolean){
		showNextFragment.postValue(showNext)
		fizzBuzzString.postValue("")
	}
	
	suspend fun getFizzBuzzText() {
			data?.let {
				calculateFizzBuzz(it)
					.onSuccess { result ->
						setContentState(result)
					}
					.onFailure {
						setErrorState()
					}
			}
	}
	
	private fun setContentState(transactionsResult: String) {
		fizzBuzzString.postValue(transactionsResult)
	}
	
	
	private fun setErrorState() {
		setContentState("Error while charging the text! Please try again.")
	}
	
	fun getFizzBuzzData(): FizzBuzzData? {
		return data
	}
}