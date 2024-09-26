package com.example.animes.presentation.signup

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
object SignUpRoute

fun NavGraphBuilder.signUp(
    navigateToHome: () -> Unit
) {
    composable<SignUpRoute> {
        val viewModel = koinViewModel<SignUpViewModel>()
        val uiState by viewModel.uiState.collectAsState(initial = SignUpUiState())
        val scope = rememberCoroutineScope()
        val signInIsSuccessful by viewModel.signUpIsSuccessful.collectAsState(initial = false) //Coletar o estado do fluxo para confirmar se o cadastro foi realizado com sucesso

        LaunchedEffect(signInIsSuccessful){
            if(signInIsSuccessful){
                navigateToHome()
            }
        }

        SignUp(uiState = uiState,
            onSignUp = {
                scope.launch { viewModel.signUp() }
            })
    }
}