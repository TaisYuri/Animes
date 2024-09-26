package com.example.animes.presentation.home

import com.example.animes.domain.usecase.getTopAnimesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animes.domain.model.TopAnimeList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel(
    private val getTopAnimesUseCase: getTopAnimesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

//    init {
//        getTopAnimes()
//    }

    private fun getTopAnimes(
        type: String? = "",
        filter: String? = "",
        rating: String? = "",
        page: Int? = 1,
        limit: Int? = 25
    ) {
        viewModelScope.launch {
            getTopAnimesUseCase.invoke(type, filter, rating, page, limit)
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .onCompletion { _uiState.update { it.copy(isLoading = false) } }
                .collectLatest { success(it) }
        }

    }

    private fun success(topAnimeList: TopAnimeList) {
        _uiState.update {
            it.copy(topAnimes = topAnimeList)
        }
    }

}