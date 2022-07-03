package com.borshevskiy.animeapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.borshevskiy.animeapp.data.local.AnimeDatabase
import com.borshevskiy.animeapp.data.paging_source.HeroRemoteMediator
import com.borshevskiy.animeapp.data.remote.ServerApi
import com.borshevskiy.animeapp.domain.model.Hero
import com.borshevskiy.animeapp.domain.repository.RemoteDataSource
import com.borshevskiy.animeapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val serverApi: ServerApi,
    private val animeDatabase: AnimeDatabase): RemoteDataSource {

    private val heroDao = animeDatabase.heroDao()

    @ExperimentalPagingApi
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = {
            heroDao.getAllHeroes()
        }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(serverApi, animeDatabase),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}