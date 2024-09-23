package com.example.animes.di

import com.example.animes.data.api.Services
import com.example.animes.data.datasource.TopAnimeListDataSource
import com.example.animes.data.datasource.TopAnimeListDataSourceImpl
import com.example.animes.data.mapper.TopAnimesMapper
import com.example.animes.data.repository.TopAnimeListRepository
import com.example.animes.data.repository.TopAnimeListRepositoryImpl
import com.example.animes.domain.usecase.getTopAnimesUseCase
import com.example.animes.presentation.home.HomeViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf

val networkModule = module {
    single<Gson> { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
            .build()
    }
    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }

    single<Retrofit.Builder> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
    }
    single<Retrofit>(named("anime")) {
        get<Retrofit.Builder>()
            .baseUrl("https://api.jikan.moe/v4/")
            .build()
    }
    single<Services> {
        get<Retrofit>(named("anime")).create(Services::class.java)
    }
}

val dataModule = module {
    factory<TopAnimeListDataSource> {
        TopAnimeListDataSourceImpl(
            service = get(),
            mapper = TopAnimesMapper()
        )
    }
    factory<TopAnimeListRepository> { TopAnimeListRepositoryImpl(get()) }
}

val domainModule = module {
    factory { getTopAnimesUseCase(get()) }
}

val presentationModule = module{
    viewModelOf(::HomeViewModel)
}