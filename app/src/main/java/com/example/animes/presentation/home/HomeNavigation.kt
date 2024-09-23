package com.example.animes.presentation.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.animes.presentation.details.DETAILS
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

const val HOME = "home"

@OptIn(KoinExperimentalAPI::class)
fun NavGraphBuilder.home(navigateToDetails: (id: String) -> Unit) {
    composable(HOME) {
        val viewModel = koinNavViewModel<HomeViewModel>()
        val uiState by viewModel.uiState.collectAsState(initial = HomeUiState())

        Home(uiState = uiState, navigateToDetails = navigateToDetails)
    }
}

fun NavHostController.onNavigateToDetails(id: String) {
    navigate("$DETAILS/$id")
}