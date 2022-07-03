package com.borshevskiy.animeapp.di

import com.borshevskiy.animeapp.data.local.AnimeDatabase
import com.borshevskiy.animeapp.data.remote.ServerApi
import com.borshevskiy.animeapp.data.repository.RemoteDataSourceImpl
import com.borshevskiy.animeapp.domain.repository.RemoteDataSource
import com.borshevskiy.animeapp.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES).build()
    }


    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient).addConverterFactory(Json.asConverterFactory(contentType)).build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ServerApi {
        return retrofit.create(ServerApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(serverApi: ServerApi, animeDatabase: AnimeDatabase): RemoteDataSource {
        return RemoteDataSourceImpl(serverApi, animeDatabase)
    }


}