package com.example.animes.presentation.details

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val DETAILS = "details"

fun NavGraphBuilder.details() {
    composable("$DETAILS/{id}") { backStackEntry ->
        backStackEntry.arguments?.getString("id")?.let { id ->
            Details(id)
        } ?: LaunchedEffect(null) { }
    }
}