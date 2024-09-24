package com.example.animes.presentation.settings

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.animes.domain.model.UserPreferences
import com.example.animes.presentation.UserViewModel

const val SETTINGS = "settings"

fun NavGraphBuilder.settings(userPreferences: UserPreferences) {
    composable(SETTINGS) {
//        val viewModel = viewModel<SettingsViewModel>()
//        val uiState by viewModel.uiState.collectAsState(initial = SettingsUiState())
        Settings(userPreferences = userPreferences)
    }
}