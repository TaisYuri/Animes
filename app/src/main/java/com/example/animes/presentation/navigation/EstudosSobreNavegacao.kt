package com.example.animes.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions

// As rotas devem ser extraidas para uma constante, assim manteremos um controle melhor sobre as rotas.
private const val TELA_COM_DADOS = "telaComDados"
private const val SEGUNDA_TELA = "segundaTela"
private const val TERCEIRA_TELA = "terceiraTela"

@Composable
fun TelaRecebendoDados(user: String) {
    Column {
        Text(
            text = "Hello $user!",
            modifier = Modifier.background(color = Color.Gray)
        )
        Button(onClick = { }) {
            Text(text = "Click me")
        }
    }
}

@Composable
fun SegundaTela(onClick: () -> Unit, onBackClick: () -> Unit) {
    Column {
        Text(
            text = "Hello Segunda Tela!",
            modifier = Modifier.background(color = Color.Red)
        )
        Button(onClick = { onClick() }) {
            Text(text = "Click me")
        }

        Button(onClick = { onBackClick() }) {
            Text(text = "Voltar")
        }
    }
}

@Composable
fun TerceiraTela(onClick: () -> Unit, onBackClick: () -> Unit) {
    Column {
        Text(
            text = "Hello Terceira Tela!",
            modifier = Modifier.background(color = Color.Green)
        )
        Button(onClick = { onClick() }) {
            Text(text = "Click me")
        }

        Button(onClick = { onBackClick() }) {
            Text(text = "Voltar")
        }
    }
}

@Composable
fun NavigationInitial() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "$TELA_COM_DADOS/{user}"
    ) {
        screenWithInfo(
            navigateToSecondScreen = {
                navController.navigateToSecondScreen()
            }
        )
        secondScreen(
            navigateToThirdScreen = {
                navController.navigateToThirdScreen()
            },
            onBackClicked = {
                navController.onBackScreen()
            }
        )
        thirdScreen(
            navigateToScreenWithInfo = { user ->
                navController.navigateToScreenWithInfo(user)
            },
            onBackClick = {
                navController.onBackScreen()
            }
        )

    }
}

// Type Safety preve que deve-se extrair as funções separadamente para um melhor controle.
// Costuma-se deixar dentro de uma pasta navigation, e arquivo com nome da tela+Navigation.kt
// (Option + command + M, em cima da função que será extraida (assim criará esta função))
// O controle de navegação não será responsabilidade deste contexto.
fun NavGraphBuilder.screenWithInfo(
    navigateToSecondScreen: (NavOptions) -> Unit
) {
    composable("$TELA_COM_DADOS/{user}") { backStackEntry ->
        backStackEntry.arguments?.getString("user")?.let { user ->
            TelaRecebendoDados(user = user)
        } ?: LaunchedEffect(null) {
            navigateToSecondScreen(navOptions { popUpTo(ConversationGraphRoutePattern) })
        }
    }
}

fun NavGraphBuilder.secondScreen( navigateToThirdScreen: () -> Unit, onBackClicked: () ->Unit) {
    composable(SEGUNDA_TELA) {
        SegundaTela(
            onClick = {
                navigateToThirdScreen()
            },
            onBackClick = {
                onBackClicked()
            }
        )
    }
}

fun NavGraphBuilder.thirdScreen(navigateToScreenWithInfo: (String)-> Unit,onBackClick: () -> Unit) {
    composable(TERCEIRA_TELA) {
        val user = "teste de nome de variavel"
        TerceiraTela(
            onClick = {
                navigateToScreenWithInfo(user)
            },
            onBackClick = {
                onBackClick()
            }
        )
    }
}


// Extraindo as funções de navegação
fun NavHostController.navigateToScreenWithInfo(user: String) {
    navigate("$TELA_COM_DADOS/$user")
}

fun NavHostController.navigateToThirdScreen() {
    navigate(TERCEIRA_TELA)
}

fun NavHostController.onBackScreen() {
    popBackStack()
}

fun NavHostController.navigateToSecondScreen() {
    navigate(SEGUNDA_TELA)
}