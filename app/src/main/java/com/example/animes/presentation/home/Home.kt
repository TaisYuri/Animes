package com.example.animes.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.animes.presentation.details.Detail

@Composable
fun Home(
    uiState: HomeUiState,
    navigateToDetails: (Detail) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(!uiState.topAnimes?.data.isNullOrEmpty()){
        uiState.topAnimes?.data?.forEach { item ->
            Text(
                text = item.title,
                fontSize = 13.sp
            )
        }}
        Button(
            onClick = { navigateToDetails(Detail(id = "1")) }) {
            Text(text = "Details")
        }
    }
}