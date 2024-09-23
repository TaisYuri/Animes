package com.example.animes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.animes.presentation.navigation.AnimeNavHost
import com.example.animes.ui.theme.AnimeSTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeSTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background
                ) {
                    AnimeNavHost(navController = navController)
                }
            }
        }
    }
}
