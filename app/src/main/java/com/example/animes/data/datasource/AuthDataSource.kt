package com.example.animes.data.datasource

import com.google.firebase.auth.FirebaseAuth

interface AuthDataSource {
    suspend fun createUser(email: String, password: String)
    suspend fun signIn(email: String, password: String)
    fun signOut()
    fun authListener(listener: FirebaseAuth.AuthStateListener)
}