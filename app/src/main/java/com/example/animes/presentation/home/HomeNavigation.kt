package com.example.animes.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.animes.presentation.details.DETAILS
import com.example.animes.presentation.navigation.HOME_GRAPH

const val HOME = "home"

fun NavGraphBuilder.home(navigateToDetails: (id: String) -> Unit) {
    composable(HOME) {
        Home(navigateToDetails)
    }
}

fun NavHostController.onNavigateToDetails(id: String) {
    navigate("$DETAILS/$id")
}