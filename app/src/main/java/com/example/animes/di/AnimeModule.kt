package com.example.animes.di

import com.example.animes.data.api.Services
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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