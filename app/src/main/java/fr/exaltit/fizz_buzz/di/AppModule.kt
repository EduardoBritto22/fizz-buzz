package fr.exaltit.fizz_buzz.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import fr.exaltit.fizz_buzz.domain.use_cases.CalculateFizzBuzzUseCase
import fr.exaltit.fizz_buzz.domain.use_cases.ICalculateFizzBuzzUseCase

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
	@Provides
	fun provideCalculateFizzBuzzUseCase(): ICalculateFizzBuzzUseCase = CalculateFizzBuzzUseCase()
	
}