package com.example.animes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

private const val SEGUNDA_TELA = "segundaTela"

@Composable
fun NestedGraphNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ConversationGraphRoutePattern
    ) {
        conversationGraph(
            onNavigateToThirdScreen = { navController.navigateToThirdScreen() },
            onNavigateToScreenWithInfo = { user -> navController.navigateToScreenWithInfo(user) },
            onBackNavigateScreen = { navController.popBackStack() }
        )
        screenWithInfo(
            navigateToSecondScreen = {
                navController.navigateToGroupRoutes(it)
            }
        )
    }
}

// Normalmente com nome de arquivo ConversationGraphNavigation.kt"
const val ConversationGraphRoutePattern = "GroupRoutes"

private fun NavGraphBuilder.conversationGraph(
    onNavigateToThirdScreen: () -> Unit,
    onBackNavigateScreen: () -> Unit,
    onNavigateToScreenWithInfo: (String) -> Unit
) {
    navigation(
        route = ConversationGraphRoutePattern,
        startDestination = SEGUNDA_TELA
    ) {
        secondScreen(
            navigateToThirdScreen = {
                onNavigateToThirdScreen()
            },
            onBackClicked = onBackNavigateScreen
        )
        thirdScreen(
            navigateToScreenWithInfo = onNavigateToScreenWithInfo,
            onBackClick = onBackNavigateScreen
        )
    }
}

// As telas que fazem parte do grupo de rotas devem ser acessadas pelo nome da rota do grupo e não da tela especifica
// NAVOPTIONS é um objeto que contém as configurações de navegação. Com ela podemos remover pilhas de telas.
// exem de navOptions com popUpTo em navigateToSecondScreen
fun NavHostController.navigateToGroupRoutes(navOptions: NavOptions) {
    navigate(ConversationGraphRoutePattern, navOptions)
}