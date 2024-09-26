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
import androidx.navigation.navigation
import com.example.animes.domain.model.ItemsNavigateRoute
import com.example.animes.domain.model.UserPreferences
import com.example.animes.presentation.details.Detail
import com.example.animes.presentation.details.DetailsRoute
import com.example.animes.presentation.details.details
import com.example.animes.presentation.home.HomeRoute
import com.example.animes.presentation.home.home
import com.example.animes.presentation.settings.settings
import com.example.animes.presentation.signin.SignInRoute
import com.example.animes.presentation.signin.signIn
import com.example.animes.presentation.signup.SignUpRoute
import com.example.animes.presentation.signup.signUp
import kotlinx.serialization.Serializable


@Composable
fun AnimeNavHost(navController: NavHostController, userPreferences: UserPreferences) {
    NavHost(
        navController = navController,
        startDestination = LoginRoute,
    ) {
        loginGraph(
            onNavigateToSignUp = { navController.navigate(route = SignUpRoute) },
            onNavigateToHome = { navController.navigate(route = InitialRoute) })
        initial(
            userPreferences = userPreferences,
            onNavigateToLogin = { navController.navigate(route = LoginRoute) })
    }
}

@Serializable
object LoginRoute

//Grafo para telas de login
fun NavGraphBuilder.loginGraph(
    onNavigateToHome: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    navigation<LoginRoute>(startDestination = SignInRoute) {
        signIn(
            navigateToHome = { onNavigateToHome() },
            navigateToSignUp = { onNavigateToSignUp() }
        )
        signUp(navigateToHome = { onNavigateToHome() })
    }

}


@Serializable
object InitialRoute

//Grafo que cuidará das telas com bottomAppBar
//OBS: Necessário ter um navController interno. Não é possivel utilizar um NavController para mais de um navHost
fun NavGraphBuilder.initial(userPreferences: UserPreferences, onNavigateToLogin: () -> Unit) {
    composable<InitialRoute> {
        val navController = rememberNavController()

        Column(Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = ItemsNavigateRoute.HomeGraph,
                Modifier.weight(1f)
            ) {
                homeGraph(onNavigateToDetails = { detail ->
                    navController.navigate(DetailsRoute(detail.id))
                })
                settings(
                    userPreferences = userPreferences,
                    navigateToSignIn = onNavigateToLogin
                )
            }
            BottomNavigate(navController = navController)
        }
    }
}


fun NavGraphBuilder.homeGraph(
    onNavigateToDetails: (Detail) -> Unit
) {
    navigation<ItemsNavigateRoute.HomeGraph>(startDestination = HomeRoute) {
        home(navigateToDetails = onNavigateToDetails)
        details()
    }

}