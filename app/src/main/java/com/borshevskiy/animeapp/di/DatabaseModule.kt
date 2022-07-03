package com.borshevskiy.animeapp.di

import android.content.Context
import androidx.room.Room
import com.borshevskiy.animeapp.data.local.AnimeDatabase
import com.borshevskiy.animeapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =  Room.databaseBuilder(
            context, AnimeDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideHeroDAO(database: AnimeDatabase) = database.heroDao()

    @Singleton
    @Provides
    fun provideHeroRemoteKeyDaoDAO(database: AnimeDatabase) = database.heroRemoteKeyDao()
}