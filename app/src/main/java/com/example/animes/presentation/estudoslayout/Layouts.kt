package com.example.animes.presentation.estudoslayout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.GridGoldenratio
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private sealed class Layouts {
    data object List : Layouts()
    data object Grid : Layouts()
    data object Staggered : Layouts()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutsScreen() {
    val listStrs = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. 500s,It has survived not only five centuries, but also the leap into elect",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac",
        "Lorem Ipsum is simply dummy text of the printingnly five centuries, but also the leap into elect",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. 500s,It has survived not onlalso the leap into elect",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. 500s,It has survived not only five centuries, but also the leap into elect"
    )
    var currentLayout by remember {
        mutableStateOf<Layouts>(Layouts.List)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(title = { Text(text = "Layouts") },
            actions = {
                Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = Icons.Default.Collections,
                        contentDescription = null,
                        modifier = Modifier.clickable { currentLayout = Layouts.List })
                    Icon(
                        imageVector = Icons.Default.GridView,
                        contentDescription = null,
                        modifier = Modifier.clickable { currentLayout = Layouts.Grid })
                    Icon(
                        imageVector = Icons.Default.GridGoldenratio,
                        contentDescription = null,
                        modifier = Modifier.clickable { currentLayout = Layouts.Staggered })
                }
        })
        when (currentLayout) {
            Layouts.List -> {
                LazyColumn {
                    items(listStrs) {
                        Cards(it)
                    }
                }
            }

            Layouts.Grid -> {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(listStrs) {
                        Cards(it)
                    }
                }
            }

            Layouts.Staggered -> {
                LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
                    items(listStrs) {
                        Cards(it)
                    }
                }
            }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(listStrs) {
                Cards(it)
            }
        }
    }
}

@Composable
fun Cards(title: String) {
    Box(modifier = Modifier.padding(12.dp)) {
        Card(
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(modifier = Modifier.padding(12.dp), text = title)
        }
    }
}

