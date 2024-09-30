package com.example.animes.presentation.signin

import androidx.lifecycle.ViewModel
import com.example.animes.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val onChangePassword: (String) -> Unit = {},
    val onChangeEmail: (String) -> Unit = {},
    val error: String? = null,
    val isShowPassword: Boolean = false,
    val onTogglePasswordVisibility: () -> Unit = {}
)

class SignInViewModel(
    private val authRepository: AuthRepositoryImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onChangeEmail = { email ->
                    _uiState.update { it.copy(email = email) }
                },
                onChangePassword = { password ->
                    _uiState.update { it.copy(password = password) }
                },
                onTogglePasswordVisibility = {
                    _uiState.update { it.copy(isShowPassword = !_uiState.value.isShowPassword) }
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
            delay(3000)
            _uiState.update { it.copy(error = null) }

        }
    }

}