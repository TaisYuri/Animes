package com.example.animes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animes.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val isDarkMode = userRepository.isDarkMode

    fun onChangeMode(isDarkMode: Boolean) {
        viewModelScope.launch {
            userRepository.onChangeMode(isDarkMode)
        }
    }
}