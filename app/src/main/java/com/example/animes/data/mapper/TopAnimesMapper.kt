package com.example.animes.data.mapper

import com.example.animes.data.model.ImageJpgResponse
import com.example.animes.data.model.ImagesResponse
import com.example.animes.data.model.TopAnimeDataResponse
import com.example.animes.data.model.TopAnimeListResponse
import com.example.animes.data.model.TopAnimePaginationResponse
import com.example.animes.data.model.TrailerResponse
import com.example.animes.domain.model.ImageJpg
import com.example.animes.domain.model.Images
import com.example.animes.domain.model.TopAnimeData
import com.example.animes.domain.model.TopAnimeList
import com.example.animes.domain.model.TopAnimePagination
import com.example.animes.domain.model.Trailer

class TopAnimesMapper {

    fun mapTopAnimeListItem(topAnimeItem: TopAnimeListResponse) =
        TopAnimeList(
            data = topAnimeItem.data?.map { it.toDomain() },
            pagination = topAnimeItem.pagination?.toDomain()
        )
}

private fun TopAnimeDataResponse.toDomain() =
    TopAnimeData(
        malId = malId,
        url = url.orEmpty(),
        images = images.toDomain(),
        trailer = trailer.toDomain(),
        title = title.orEmpty(),
        type = type.orEmpty(),
        source = source.orEmpty(),
        episodes = episodes.orEmpty()
    )

private fun TopAnimePaginationResponse.toDomain() =
    TopAnimePagination(
        lastVisiblePage = lastVisiblePage,
        hasNextPage = hasNextPage
    )

private fun ImagesResponse.toDomain() =
    Images(
        jpg = jpg?.toDomain()
    )

private fun ImageJpgResponse.toDomain() =
    ImageJpg(
        largeImageUrl = largeImageUrl.orEmpty()
    )

private fun TrailerResponse.toDomain() =
    Trailer(
        youtubeId = youtubeId.orEmpty(),
        url = url.orEmpty()
    )