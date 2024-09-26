package com.example.animes.presentation.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.animes.presentation.details.Detail
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
object HomeRoute

fun NavGraphBuilder.home(navigateToDetails: (Detail) -> Unit) {
    composable<HomeRoute> {
        val viewModel = koinViewModel<HomeViewModel>()
        val uiState by viewModel.uiState.collectAsState(initial = HomeUiState())

        Home(uiState = uiState, navigateToDetails = navigateToDetails)
    }
}
