package com.example.animes.presentation.signin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SIGN_IN = "signIn"

fun NavGraphBuilder.signIn(navigateToHome: () -> Unit){
    composable(SIGN_IN) {
        SignIn(navigateToHome)
    }
}