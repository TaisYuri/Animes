package com.example.animes.presentation.settings

import androidx.lifecycle.ViewModel
import com.example.animes.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SettingsViewModel(
    private val authRepository: AuthRepositoryImpl
): ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy (
                onChangeMode = { isDarkMode ->
                    _uiState.update { currentState ->
                        currentState.copy(isDarkMode = isDarkMode)
                    }
                }
            )
        }
    }

    fun signOut(){
        authRepository.signOut()
    }
}