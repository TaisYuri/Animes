package com.example.animes.data.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    val isDarkMode: Flow<Boolean>
    suspend fun onChangeMode(isDarkMode: Boolean): Preferences
}