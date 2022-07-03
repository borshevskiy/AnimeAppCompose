package com.borshevskiy.animeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.borshevskiy.animeapp.data.local.dao.DatabaseConverter
import com.borshevskiy.animeapp.data.local.dao.HeroDao
import com.borshevskiy.animeapp.data.local.dao.HeroRemoteKeyDao
import com.borshevskiy.animeapp.domain.model.Hero
import com.borshevskiy.animeapp.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverter::class)
abstract class AnimeDatabase: RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}