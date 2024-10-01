package com.example.animes.presentation.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
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

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.home(navigateToDetails: (Detail) -> Unit) {
    composable<HomeRoute> {
        val viewModel = koinViewModel<HomeViewModel>()
        val uiState by viewModel.uiState.collectAsState(initial = HomeUiState())
        val stateRefreshState = rememberPullToRefreshState()
        Home(
            uiState = uiState,
            navigateToDetails = navigateToDetails,
            isRefreshing = uiState.isRefreshing,
            stateRefreshState = stateRefreshState,
            onRefresh = { viewModel.onRefresh() })
    }
}
