package com.example.animes.presentation.signin

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
object SignInRoute

fun NavGraphBuilder.signIn(
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    composable<SignInRoute> {
        val viewModel = koinViewModel<SignInViewModel>()
        val uiState by viewModel.uiState.collectAsState(initial = SignInUiState())
        val scope = rememberCoroutineScope()
        val isAuthenticated = viewModel.isAuthenticated.collectAsState(initial = false).value

        LaunchedEffect(isAuthenticated) {
            if (isAuthenticated) {
                navigateToHome()
            }
        }

        SignIn(
            uiState = uiState,
            onSignIn = {
                scope.launch { viewModel.signIn() }
            },
            navigateToSignUp = navigateToSignUp
        )
    }
}