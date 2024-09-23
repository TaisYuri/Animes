package com.example.animes.data.repository

import com.example.animes.data.datasource.TopAnimeListDataSource
import com.example.animes.domain.model.TopAnimeList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

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
        dataSource.getTopAnimeList(type, filter, rating, page, limit).flowOn(Dispatchers.IO)

}