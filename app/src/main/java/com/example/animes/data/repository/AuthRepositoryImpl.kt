package com.example.animes.data.repository

import com.example.animes.data.datasource.AuthDataSourceImpl
import com.example.animes.data.model.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthRepositoryImpl(
    private val dataSourceImpl: AuthDataSourceImpl
): AuthRepository{
    private val _currentUser = MutableStateFlow<AuthResult>(AuthResult())
    val currentUser = _currentUser.asStateFlow()

    init{
        dataSourceImpl.authListener{ firebaseAuth ->
            _currentUser.update {
                it.copy(
                    user = firebaseAuth.currentUser,
                    isInitLoading = false
                )
            }
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