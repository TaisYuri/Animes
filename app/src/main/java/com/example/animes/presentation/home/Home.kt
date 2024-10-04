package com.example.animes.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.runtime.remember
import com.example.animes.domain.model.TopAnimeData
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
            .fillMaxSize(),
        topBar = { TopAppBarNavigation() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .pullToRefresh(
                    state = stateRefreshState,
                    isRefreshing = isRefreshing,
                    onRefresh = onRefresh,
                )
        ) {
            if (uiState.topAnimes?.data?.isNotEmpty() == true) {
                LazyColumn (
                    modifier =Modifier
                        .weight(1f)
                        .background(Color.Red)
                ) {
                    item {
                        Column(Modifier.padding(8.dp)) {
                            Text(
                                text = "Top 10 Animes",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            LazyRow(
                                Modifier
                                    .defaultMinSize(minHeight = 225.dp)
                            ) {
                                items(uiState.topAnimes.data) {
                                    Cards(
                                        data = it,
                                        title = it.title,
                                        urlImage = it.images.jpg?.largeImageUrl.orEmpty(),
                                        navigateToDetails = navigateToDetails
                                    )
                                }
                            }
                        }
                    }
                    item {
                        Column(Modifier.padding(8.dp)) {
                            Text(
                                text = "Top 10 Animes",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            LazyRow(
                                Modifier
                                    .defaultMinSize(minHeight = 225.dp)
                            ) {
                                items(uiState.topAnimes.data) {
                                    Cards(
                                        data =it,
                                        title = it.title,
                                        urlImage = it.images.jpg?.largeImageUrl.orEmpty(),
                                        navigateToDetails = navigateToDetails
                                    )
                                }
                            }
                        }
                    }

                }
                if (isRefreshing) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                } else {
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                        progress = { stateRefreshState.distanceFraction }
                    )
                }
                Button(onClick = {})
                { Text(text = isRefreshing.toString()) }
                Button(
                    onClick = {  }) {
                    Text(text = "Details")
                }
                Button(
                    onClick = { }) {
                    Text(text = "Details")
                }
            }

        }
    }
}
