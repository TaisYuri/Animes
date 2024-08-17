package com.example.animes

import android.app.Application
import com.example.animes.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnimeApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    networkModule
                )
            )
            androidLogger()
            androidContext(this@AnimeApplication)
        }
    }
}