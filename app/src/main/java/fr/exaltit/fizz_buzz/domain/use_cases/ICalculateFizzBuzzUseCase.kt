package fr.exaltit.fizz_buzz.domain.use_cases

import fr.exaltit.fizz_buzz.domain.model.FizzBuzzData

interface ICalculateFizzBuzzUseCase {
	suspend operator fun invoke(data: FizzBuzzData):List<String>
}