package com.example.animes.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(
    uiState: HomeUiState,
    navigateToDetails: (id: String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        uiState.topAnimes?.data?.forEach { item ->
            Text(
                text = item.title,
                fontSize = 13.sp
            )
        }
        Button(
            onClick = { navigateToDetails("1") }) {
            Text(text = "Details")
        }
    }
}