package com.example.animes.data.api

import com.example.animes.data.model.TopAnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("top/anime")
    suspend fun getTopAnimeList(
        @Query("type") type: String?,
        @Query("filter") filter: String?,
        @Query("rating") rating: String?,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
    ) : TopAnimeListResponse
}