package com.example.animes.presentation.signup

import androidx.lifecycle.ViewModel
import com.example.animes.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class SignUpUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val onChangePassword: (String) -> Unit = {},
    val onChangeEmail: (String) -> Unit = {},
    val onChangeName: (String) -> Unit = {},
    val error: String? = null
)

class SignUpViewModel (
    private val firebaseRepository: AuthRepositoryImpl
): ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    //SharedFlow é um fluxo frio, o que significa que só começará a emitir valores quando tiver pelo menos um coletor.
    //Não armazena valores anteriores, apenas os valores emitidos após a coleta começar. E não guarda estado
    private val _signUpIsSuccessful = MutableSharedFlow<Boolean>()
    val signUpIsSuccessful = _signUpIsSuccessful.asSharedFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy (
                onChangeEmail = { email ->
                    _uiState.update { it.copy(email = email) }
                },
                onChangePassword = { password ->
                    _uiState.update { it.copy(password = password) }
                },
                onChangeName = { name ->
                    _uiState.update { it.copy(name = name) }
                }
            )
        }
    }

    suspend fun signUp(){
        try {
            firebaseRepository.createUser(
                email = _uiState.value.email,
                password = _uiState.value.password
            )
            _signUpIsSuccessful.emit(true)
        }catch (e: Exception){
            _uiState.update { it.copy(error = e.message) }
        }
    }
}