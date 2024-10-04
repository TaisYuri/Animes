package com.example.animes.domain.model

data class TopAnimeList(
    val data: List<TopAnimeData>? = emptyList(),
    val pagination: TopAnimePagination? = null,
)

data class TopAnimeData(
    val malId: Int,
    val url: String,
    val images: Images,
    val trailer: Trailer,
    val title: String,
    val type: String,
    val source: String,
    val episodes: String,
    val status: String? = null,
    val aired: Aired? = null,
    val duration: String? = null,
    val score: Double? = null,
    val synopsis: String? = null,
    val year: String? = null,
    val genres: List<Genres>? = null
)

data class TopAnimePagination(
    val lastVisiblePage: Int,
    val hasNextPage: Boolean
)

data class Images(
    val jpg: ImageJpg? = null
)

data class ImageJpg(
    val largeImageUrl: String
)

data class Trailer(
    val youtubeId: String,
    val url: String
)


data class Aired(
    val from: String? = null,
    val to: String? = null
)

data class Genres(
    val malId: String? = null,
    val type: String? = null,
    val name: String? = null,
)