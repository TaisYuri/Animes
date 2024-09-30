package com.example.animes.presentation.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.animes.domain.model.ItemsNavigateRoute
import com.example.animes.domain.model.UserPreferences
import org.koin.compose.viewmodel.koinViewModel

fun NavGraphBuilder.settings(userPreferences: UserPreferences, navigateToSignIn: () -> Unit) {
    composable<ItemsNavigateRoute.SettingsRoute> {
        val viewModel = koinViewModel<SettingsViewModel>()

        Settings(userPreferences = userPreferences,
            onExitAccount = {
                viewModel.signOut()
            })
    }
}