package com.example.animes.data.datasource

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthDataSourceImpl(
    private val firebaseAuth: FirebaseAuth
): AuthDataSource {
    override suspend fun createUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .await()
    }

    override suspend fun signIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .await()
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }

    override fun authListener(listener: FirebaseAuth.AuthStateListener){
        firebaseAuth.addAuthStateListener(listener)
    }
}