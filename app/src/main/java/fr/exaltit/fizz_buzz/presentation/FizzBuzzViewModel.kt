package fr.exaltit.fizz_buzz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import fr.exaltit.fizz_buzz.domain.use_cases.CalculateFizzBuzzUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class FizzBuzzViewModel @Inject constructor(
	private val calculateFizzBuzz: CalculateFizzBuzzUseCase
) : ViewModel() {
	
	private val fizzBuzzDataInput = MutableLiveData<FizzBuzzData>()
	val fizzBuzzStringList: LiveData<List<String>> = Transformations.switchMap(fizzBuzzDataInput) { address ->
		liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
			emit(calculateFizzBuzz(address))
		}
	}
	
	val isLoading = MutableLiveData<Boolean>()
	private var data: FizzBuzzData? = null
	
	init {
		isLoading.postValue(false)
	}
	
	fun setFizzBuzzData(firstWord: String, secondWord: String, firstMultiple: Long, secondMultiple: Long, limit: Long) {
		data = FizzBuzzData(
			firstMultiple = firstMultiple,
			secondMultiple = secondMultiple,
			limit = limit,
			firstWord = firstWord,
			secondWord = secondWord
		).apply {
			fizzBuzzDataInput.value = this
		}
		
		isLoading.postValue(true)
	}
	
	fun getFizzBuzzData(): FizzBuzzData? {
		return data
	}
}