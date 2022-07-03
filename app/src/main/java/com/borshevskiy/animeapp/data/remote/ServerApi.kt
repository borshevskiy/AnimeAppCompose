package com.borshevskiy.animeapp.data.remote

import com.borshevskiy.animeapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ServerApi {

    @GET("/server/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ) : ApiResponse

    @GET("/server/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ) : ApiResponse

}