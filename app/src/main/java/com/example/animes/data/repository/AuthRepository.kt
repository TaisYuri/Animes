package com.example.animes.data.repository

interface AuthRepository {
    suspend fun createUser(email: String, password: String)
    suspend fun signIn(email: String, password: String)
    fun signOut()
}