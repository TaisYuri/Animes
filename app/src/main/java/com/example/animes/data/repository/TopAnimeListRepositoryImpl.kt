package com.example.animes.data.repository

import com.example.animes.data.datasource.TopAnimeListDataSource
import com.example.animes.domain.model.TopAnimeList
import kotlinx.coroutines.flow.Flow

class TopAnimeListRepositoryImpl(
    private val dataSource: TopAnimeListDataSource
): TopAnimeListRepository {
    override fun getTopAnimeList(
        type: String?,
        filter: String?,
        rating: String?,
        page: Int?,
        limit: Int?
    ): Flow<TopAnimeList> =
        dataSource.getTopAnimeList(type, filter, rating, page, limit)

}