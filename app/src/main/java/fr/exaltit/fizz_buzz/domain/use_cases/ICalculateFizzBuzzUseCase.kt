package fr.exaltit.fizz_buzz.domain.use_cases

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData

interface ICalculateFizzBuzzUseCase {
	operator fun invoke(data: FizzBuzzData): Result<String>
}