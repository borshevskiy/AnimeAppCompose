package com.borshevskiy.animeapp.domain.use_cases.read_onboarding

import com.borshevskiy.animeapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}