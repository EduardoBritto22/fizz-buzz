package fr.exaltit.fizz_buzz.domain.use_cases

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData
import fr.exaltit.fizz_buzz.utils.FizzBuzzCalculator
import javax.inject.Inject

class CalculateFizzBuzzUseCase @Inject constructor(): ICalculateFizzBuzzUseCase {
	override suspend fun invoke(data: FizzBuzzData): Result<String> {
		val fizzBuzzText = FizzBuzzCalculator(data).getFizzBuzzText()
		return Result.success(fizzBuzzText)
	}
}