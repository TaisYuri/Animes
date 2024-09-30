package com.example.animes.data.model

import com.google.firebase.auth.FirebaseUser

data class AuthResult(
    val user: FirebaseUser? = null,
    val isInitLoading: Boolean = true
)
