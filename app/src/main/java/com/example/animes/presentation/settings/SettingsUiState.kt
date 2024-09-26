package com.example.animes.presentation.settings

data class SettingsUiState(
    val isDarkMode: Boolean = false,
    val onChangeMode: (Boolean) -> Unit = {}
)
