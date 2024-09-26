package com.example.animes.data.repository

import com.example.animes.data.datasource.AuthDataSourceImpl
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthRepositoryImpl(
    private val dataSourceImpl: AuthDataSourceImpl
): AuthRepository{
    private val _currentUser = MutableStateFlow<FirebaseUser?>(null)
    val currentUser = _currentUser.asStateFlow()

    init{
        dataSourceImpl.authListener{
            _currentUser.value = it.currentUser
        }
    }

    override suspend fun createUser(email: String, password: String) {
        dataSourceImpl.createUser(email, password)
    }

    override suspend fun signIn(email: String, password: String) {
        dataSourceImpl.signIn(email, password)
    }

    override fun signOut() {
        dataSourceImpl.signOut()
    }
}