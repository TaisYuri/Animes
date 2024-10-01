package com.example.animes.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.animes.presentation.components.Cards
import com.example.animes.presentation.components.PullToRefreshLazyColumn
import com.example.animes.presentation.details.Detail
import com.example.animes.presentation.navigation.TopAppBarNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    uiState: HomeUiState,
    navigateToDetails: (Detail) -> Unit,
    isRefreshing: Boolean,
    stateRefreshState: PullToRefreshState,
    onRefresh: () -> Unit,
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        topBar = { TopAppBarNavigation() }
    ) { innerPadding ->
        if (!uiState.topAnimes?.data.isNullOrEmpty()) {
            uiState.topAnimes?.data?.forEach { item ->
                Text(
                    text = item.title,
                    fontSize = 13.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                PullToRefreshLazyColumn(
                    itemsList = test,
                    isRefreshing = isRefreshing,
                    onRefresh = onRefresh,
                    content = { Cards(it) },
                    state = stateRefreshState
                )
            }
            Button(
                onClick = { navigateToDetails(Detail(id = "1")) }) {
                Text(text = "Details")
            }
            Button(onClick = {})
                { Text(text = isRefreshing.toString()) }


        }
    }
}

val test = listOf("1", "12","232","432")