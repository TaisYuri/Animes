package com.example.animes.data.datasource

import com.example.animes.data.api.Services
import com.example.animes.data.mapper.TopAnimesMapper
import com.example.animes.domain.model.TopAnimeList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TopAnimeListDataSourceImpl(
    private val service: Services,
    private val mapper: TopAnimesMapper
): TopAnimeListDataSource {
    override fun getTopAnimeList(
        type: String?,
        filter: String?,
        rating: String?,
        page: Int?,
        limit: Int?
    ): Flow<TopAnimeList> =
        flow {
            emit(
                service.getTopAnimeList(
                    type,
                    filter,
                    rating,
                    page,
                    limit
                )
            )}.map( mapper::mapTopAnimeListItem)

}