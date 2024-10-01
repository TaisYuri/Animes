package com.example.animes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> PullToRefreshLazyColumn(
    modifier: Modifier = Modifier,
    itemsList: List<T>,
    isRefreshing: Boolean = false,
    onRefresh: () -> Unit,
    content: @Composable (T) -> Unit,
    state: PullToRefreshState = rememberPullToRefreshState()
) {
    Column(
        modifier = modifier.pullToRefresh(
            state = state,
            onRefresh = onRefresh,
            isRefreshing = isRefreshing
        ).background(Color.White).fillMaxSize()
    ) {
        LazyColumn(
            modifier =Modifier
                .padding(8.dp).background(Color.Red)

        ) {
            items(itemsList) {
                content(it)
            }
        }
    }
    if (isRefreshing) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    } else {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = { state.distanceFraction }
        )
    }

}