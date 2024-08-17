package com.example.animes.data.datasource

import com.example.animes.domain.model.TopAnimeList
import kotlinx.coroutines.flow.Flow

interface TopAnimeListDataSource {
    fun getTopAnimeList(
        type: String?,
        filter: String?,
        rating: String?,
        page: Int?,
        limit: Int?
    ): Flow<TopAnimeList>
}