package com.example.animes.presentation.signin

import androidx.lifecycle.ViewModel
import com.example.animes.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val onChangePassword: (String) -> Unit = {},
    val onChangeEmail: (String) -> Unit = {},
    val error: String? = null
)

class SignInViewModel(
    private val authRepository: AuthRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()
    val isAuthenticated = authRepository.currentUser.map { it != null }

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onChangeEmail = { email ->
                    _uiState.update { it.copy(email = email) }
                },
                onChangePassword = { password ->
                    _uiState.update { it.copy(password = password) }
                }
            )
        }
    }

    suspend fun signIn() {
        try {
            authRepository.signIn(
                email = _uiState.value.email,
                password = _uiState.value.password
            )
        } catch (e: Exception) {
            _uiState.update { it.copy(error = e.message) }
        }
    }

}