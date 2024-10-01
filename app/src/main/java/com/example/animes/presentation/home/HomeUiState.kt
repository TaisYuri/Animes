package com.example.animes.presentation.home

import com.example.animes.domain.model.TopAnimeList

data class HomeUiState(
    val topAnimes: TopAnimeList? = null,
    var isLoading: Boolean = false,
    val isRefreshing: Boolean = false
)
