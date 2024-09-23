package com.example.animes.presentation.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SETTINGS = "settings"

fun NavGraphBuilder.settings() {
    composable(SETTINGS) {
        Settings()
    }
}