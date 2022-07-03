package com.borshevskiy.animeapp.di

import android.content.Context
import com.borshevskiy.animeapp.data.repository.DataStoreOperationsImpl
import com.borshevskiy.animeapp.data.repository.Repository
import com.borshevskiy.animeapp.domain.repository.DataStoreOperations
import com.borshevskiy.animeapp.domain.use_cases.UseCases
import com.borshevskiy.animeapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.borshevskiy.animeapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(@ApplicationContext context: Context) = DataStoreOperationsImpl(context = context)

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository) = UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )
}