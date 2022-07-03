package com.borshevskiy.animeapp.domain.use_cases.save_onboarding

import com.borshevskiy.animeapp.data.repository.Repository

class SaveOnBoardingUseCase(private val repository: Repository) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed)
    }
}