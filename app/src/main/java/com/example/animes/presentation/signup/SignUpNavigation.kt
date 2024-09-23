package com.example.animes.presentation.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val SIGN_UP = "signUp"

fun NavGraphBuilder.signUp() {
    composable(SIGN_UP) {
        SignUp()
    }
}