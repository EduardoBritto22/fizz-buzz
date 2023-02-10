package fr.exaltit.fizz_buzz.domain.use_cases

import fr.exaltit.fizz_buzz.di.DefaultDispatcher
import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import fr.exaltit.fizz_buzz.domain.utils.FizzBuzzCalculator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/***
 * Use case to calculate the sequence from 1 tp limit for the given data
 */
class CalculateFizzBuzzUseCase @Inject constructor(
	@DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ICalculateFizzBuzzUseCase {
	override suspend fun invoke(data: FizzBuzzData): List<String> = withContext(defaultDispatcher) {
		FizzBuzzCalculator(data).getFizzBuzzText()
	}
	
}