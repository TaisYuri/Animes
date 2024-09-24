package com.example.animes.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animes.domain.model.UserPreferences
import com.example.animes.presentation.details.details
import com.example.animes.presentation.home.HOME
import com.example.animes.presentation.home.home
import com.example.animes.presentation.home.onNavigateToDetails
import com.example.animes.presentation.settings.settings
import com.example.animes.presentation.signin.SIGN_IN
import com.example.animes.presentation.signin.signIn
import com.example.animes.presentation.signup.signUp

private const val INITIAL_ROUTE = "initial"
const val HOME_GRAPH = "home_graph"

@Composable
fun AnimeNavHost(navController: NavHostController, userPreferences: UserPreferences) {
    NavHost(
        navController = navController,
        startDestination = SIGN_IN,
    ) {
        signIn(navigateToHome = { navController.onNavigateToHome() })
        signUp()
        initial(userPreferences = userPreferences)
    }
}

//Grafo que cuidará das telas com bottomAppBar
//OBS: Necessário ter um navController interno. Não é possivel utilizar um NavController para mais de um navHost
fun NavGraphBuilder.initial(userPreferences: UserPreferences) {
    composable(INITIAL_ROUTE) {
        val navController = rememberNavController()

        Column(Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = HOME_GRAPH,
                Modifier.weight(1f)
            ) {
                //home(navigateToDetails = { id -> navController.onNavigateToDetails(id) })
                homeGraph()
                settings(userPreferences = userPreferences)
            }
            BottomNavigate(navController = navController)
        }
    }
}

fun NavGraphBuilder.homeGraph() {
    composable(HOME_GRAPH) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = HOME) {
            home(navigateToDetails = { id -> navController.onNavigateToDetails(id) })
            details()
        }
    }
}

fun NavHostController.onNavigateToHome() {
    navigate(INITIAL_ROUTE)
}
