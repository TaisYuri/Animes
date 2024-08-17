package com.example.animes.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopAnimeListResponse(
    @SerializedName("data")
    val data: List<TopAnimeDataResponse>? = emptyList(),
    @SerializedName("pagination")
    val pagination: TopAnimePaginationResponse? = null,
) : Parcelable

@Parcelize
data class TopAnimeDataResponse(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("images")
    val images: ImagesResponse,
    @SerializedName("trailer")
    val trailer: TrailerResponse,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("episodes")
    val episodes: String? = null
    ) : Parcelable

@Parcelize
data class TopAnimePaginationResponse(
    @SerializedName("last_visible_page")
    val lastVisiblePage: Int,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean = false
) : Parcelable

@Parcelize
data class ImagesResponse(
    @SerializedName("jpg")
    val jpg: ImageJpgResponse? = null
) : Parcelable

@Parcelize
data class ImageJpgResponse(
    @SerializedName("large_image_url")
    val largeImageUrl: String? = null
) : Parcelable

@Parcelize
data class TrailerResponse(
    @SerializedName("youtube_id")
    val youtubeId: String? = null,
    @SerializedName("url")
    val url: String? = null
) : Parcelable