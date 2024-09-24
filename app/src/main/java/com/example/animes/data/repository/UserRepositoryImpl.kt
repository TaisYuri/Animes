package com.example.animes.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")

class UserRepositoryImpl(private val dataStore: DataStore<Preferences>): UserRepository {

    override val isDarkMode: Flow<Boolean>
        get() = dataStore.data.map {
            it[IS_DARK_MODE] ?: false
        }


    override suspend fun onChangeMode(isDarkMode: Boolean):Preferences =
        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = isDarkMode
        }

}