package com.example.animes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animes.data.repository.AuthRepositoryImpl
import com.example.animes.data.repository.UserRepository
import com.example.animes.domain.model.AppState
import com.example.animes.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepositoryImpl
) : ViewModel() {

    private val _state = MutableStateFlow<AppState>(AppState())
    val state = _state.combine(authRepository.currentUser){state, authResult ->
        val user = authResult.user?.email?.let { User(it) }
        state.copy(user = user, isInitialLoading = authResult.isInitLoading)
    }
    val isDarkMode = userRepository.isDarkMode

    fun onChangeMode(isDarkMode: Boolean) {
        viewModelScope.launch {
            userRepository.onChangeMode(isDarkMode)
        }
    }
}