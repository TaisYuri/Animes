package com.example.animes.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarNavigation() {
    TopAppBar(
        title = { Text(text = "Animes") },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Email, contentDescription = "Favorite")
            }
        }
    )
}