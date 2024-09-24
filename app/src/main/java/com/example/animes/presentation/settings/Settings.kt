package com.example.animes.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animes.domain.model.UserPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(userPreferences: UserPreferences) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.secondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TopAppBar(
            title = { /*TODO*/ },
            navigationIcon = {
                Switch(checked = userPreferences.isDarkMode,
                    onCheckedChange = {
                        userPreferences.onChangeMode(it)
                    },
                    thumbContent = {
                        val icon = remember(userPreferences.isDarkMode) {
                            if (userPreferences.isDarkMode) {
                                Icons.Filled.ModeNight
                            } else {
                               Icons.Filled.LightMode
                            }
                        }
                        Icon(icon, null)
                    })
            }
        )
        Text(
            modifier = Modifier.size(20.dp),
            text = "Settings"
        )
    }
}