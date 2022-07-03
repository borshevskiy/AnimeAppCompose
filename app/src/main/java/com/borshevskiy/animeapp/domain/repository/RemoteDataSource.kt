package com.borshevskiy.animeapp.domain.repository

import androidx.paging.PagingData
import com.borshevskiy.animeapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllHeroes(): Flow<PagingData<Hero>>

    fun searchHeroes(): Flow<PagingData<Hero>>
}