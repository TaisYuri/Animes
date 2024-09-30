package com.example.animes.domain.model

data class AppState(
    val user: User? = null,
    val isInitialLoading: Boolean = true
)