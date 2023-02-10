package fr.exaltit.fizz_buzz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import fr.exaltit.fizz_buzz.domain.use_cases.CalculateFizzBuzzUseCase
import fr.exaltit.fizz_buzz.domain.use_cases.ICalculateFizzBuzzUseCase

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {
	
	@Binds
	abstract fun bindCalculateFizzBuzzUseCase(
		calculateFizzBuzzUseCase:CalculateFizzBuzzUseCase
	): ICalculateFizzBuzzUseCase

	
}