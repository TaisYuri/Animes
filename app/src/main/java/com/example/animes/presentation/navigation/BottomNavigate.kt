package com.example.animes.presentation.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.example.animes.domain.model.ItemsNavigate

@Composable
fun BottomNavigate(navController: NavController) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination?.route  //Obtem a rota atual

    val items = remember {
        listOf(
            ItemsNavigate.Home, ItemsNavigate.Settings
        )
    }

    BottomAppBar(
        actions = {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentDestination == item.route.toString(),
                    onClick = {
                        navController.navigate(
                            item.route,
                            navOptions = navOptions {
                                launchSingleTop =
                                    true  // Não permite abrir mais uma instancia da mesma tela visivel
                                // popUpTo(navController.graph.id) //remove sempre todas as telas anteriores
                                popUpTo(navController.graph.startDestinationId) //remove da pilha todas as telas anteriores navegando para a  inicial

                            }
                        )

                    },
                    icon = {
                        Icon(item.icon, contentDescription = null)
                    },
                    label = { Text(text = item.title) }
                )
            }
        }
    )
}