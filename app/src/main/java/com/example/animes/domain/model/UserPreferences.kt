package com.example.animes.domain.model

data class UserPreferences(
    val onChangeMode: (Boolean) -> Unit,
    val isDarkMode: Boolean
)
