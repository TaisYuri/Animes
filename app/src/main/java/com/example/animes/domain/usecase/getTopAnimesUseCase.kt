package com.example.animes.domain.usecase

import com.example.animes.data.repository.TopAnimeListRepository

class getTopAnimesUseCase(private val repository: TopAnimeListRepository) {
    fun invoke(type: String?, filter: String?, rating: String?, page: Int?, limit: Int?) =
        repository.getTopAnimeList(type, filter, rating, page, limit)
}