package com.example.animes.data.repository

import com.example.animes.domain.model.TopAnimeList
import kotlinx.coroutines.flow.Flow

interface TopAnimeListRepository {
    fun getTopAnimeList(
        type: String?,
        filter: String?,
        rating: String?,
        page: Int?,
        limit: Int?
    ): Flow<TopAnimeList>
}