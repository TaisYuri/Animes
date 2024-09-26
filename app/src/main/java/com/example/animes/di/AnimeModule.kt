package com.example.animes.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.animes.data.api.Services
import com.example.animes.data.datasource.AuthDataSourceImpl
import com.example.animes.data.datasource.TopAnimeListDataSource
import com.example.animes.data.datasource.TopAnimeListDataSourceImpl
import com.example.animes.data.mapper.TopAnimesMapper
import com.example.animes.data.repository.AuthRepositoryImpl
import com.example.animes.data.repository.TopAnimeListRepository
import com.example.animes.data.repository.TopAnimeListRepositoryImpl
import com.example.animes.data.repository.UserRepository
import com.example.animes.data.repository.UserRepositoryImpl
import com.example.animes.domain.usecase.getTopAnimesUseCase
import com.example.animes.presentation.home.HomeViewModel
import com.example.animes.presentation.UserViewModel
import com.example.animes.presentation.settings.SettingsViewModel
import com.example.animes.presentation.signin.SignInViewModel
import com.example.animes.presentation.signup.SignUpViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf

private const val USER_PREFERENCES = "user_preferences"
val networkModule = module {
    single<Gson> { GsonBuilder().create() }
    single {
        OkHttpClient.Builder().build()
    }
    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }

    single<Retrofit.Builder> {
        Retrofit.Builder().client(get()).addConverterFactory(get<GsonConverterFactory>())
    }
    single<Retrofit>(named("anime")) {
        get<Retrofit.Builder>().baseUrl("https://api.jikan.moe/v4/").build()
    }
    single<Services> {
        get<Retrofit>(named("anime")).create(Services::class.java)
    }
}

// DATASTORE
val storageModule = module {
    single {
        PreferenceDataStoreFactory.create {
            androidContext().preferencesDataStoreFile(USER_PREFERENCES)
        }
    }
}

// FIREBASE - AUTH
val firebaseModule = module {
    single {
        Firebase.auth
    }
}

val dataModule = module {
    factory<TopAnimeListDataSource> {
        TopAnimeListDataSourceImpl(
            service = get(), mapper = TopAnimesMapper()
        )
    }
    factory<TopAnimeListRepository> { TopAnimeListRepositoryImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get()) }
    singleOf(::AuthDataSourceImpl)
    singleOf(::AuthRepositoryImpl)
}

val domainModule = module {
    factory { getTopAnimesUseCase(get()) }
}

val presentationModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::UserViewModel)
    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)
    viewModelOf(::SettingsViewModel)
}