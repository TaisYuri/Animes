package com.example.animes

import android.app.Application
import com.example.animes.di.dataModule
import com.example.animes.di.domainModule
import com.example.animes.di.networkModule
import com.example.animes.di.presentationModule
import com.example.animes.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnimeApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    networkModule,
                    storageModule,
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
            androidLogger()
            androidContext(this@AnimeApplication)
        }
    }
}