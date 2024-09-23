package com.example.animes.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.animes.presentation.navigation.HOME_GRAPH
import com.example.animes.presentation.settings.SETTINGS

sealed class ItemsNavigate(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    data object Home : ItemsNavigate("Home", Icons.Filled.Home, HOME_GRAPH)
    data object Settings : ItemsNavigate("Settings", Icons.Filled.Settings, SETTINGS)
}