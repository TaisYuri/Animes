package com.example.animes.presentation.details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

data class Detail(
    val id: String
)

@Serializable
    data class DetailsRoute(val id: String)

fun NavGraphBuilder.details() {
    composable<DetailsRoute> { backStackEntry ->
        val route: DetailsRoute = backStackEntry.toRoute()
         Details(route.id)
    }
}