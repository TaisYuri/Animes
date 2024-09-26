package com.example.animes.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

interface ItemsNavigateRoute {
    @Serializable
    object HomeGraph : ItemsNavigateRoute

    @Serializable
    object SettingsRoute : ItemsNavigateRoute
}

sealed class ItemsNavigate(
    val title: String,
    val icon: ImageVector,
    val route: ItemsNavigateRoute
) {
    data object Home : ItemsNavigate("Home", Icons.Filled.Home, ItemsNavigateRoute.HomeGraph)
    data object Settings :
        ItemsNavigate("Settings", Icons.Filled.Settings, ItemsNavigateRoute.SettingsRoute)
}