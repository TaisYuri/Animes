package com.example.animes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.animes.domain.model.UserPreferences
import com.example.animes.presentation.UserViewModel
import com.example.animes.presentation.navigation.AnimeNavHost
import com.example.animes.ui.theme.AnimeSTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val userViewModel = koinViewModel<UserViewModel>()
            val isDarkMode by userViewModel.isDarkMode.collectAsState(initial = false)
            AnimeSTheme(
                darkTheme = isDarkMode
            ) {
                val navController = rememberNavController()

                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeNavHost(
                        navController = navController,
                        UserPreferences(
                            onChangeMode = userViewModel::onChangeMode,
                            isDarkMode = isDarkMode
                        )
                    )
                }
            }
        }
    }
}
