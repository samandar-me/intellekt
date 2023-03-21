package com.sdk.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.sdk.data.model.UploadUser
import com.sdk.domain.model.Login
import com.sdk.domain.model.Register
import com.sdk.domain.repository.AuthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val storage: FirebaseStorage,
    private val fireStore: FirebaseFirestore,
) : AuthRepository {
    private var isSuccess = false
    override suspend fun isUserAuthed(): Flow<Boolean> = callbackFlow {
        val firebaseAuthListener = FirebaseAuth.AuthStateListener {
            trySend(auth.currentUser != null)
        }
        auth.addAuthStateListener(firebaseAuthListener)
        awaitClose {
            auth.removeAuthStateListener(firebaseAuthListener)
        }
    }

    override suspend fun login(login: Login): Flow<Boolean> = flow {
        isSuccess = false
        auth.signInWithEmailAndPassword(login.email, login.password).addOnSuccessListener {
            isSuccess = true
        }.await()
        emit(isSuccess)
    }

    override suspend fun register(register: Register): Flow<Boolean> = flow {
        var uploadSuccess = false
        isSuccess = false
        auth.createUserWithEmailAndPassword(register.email, register.password)
            .addOnSuccessListener {
                isSuccess = true
            }.await()
        if (isSuccess) {
            val fileName = UUID.randomUUID().toString()
            val ref = storage.getReference("images/$fileName")
            ref.putFile(register.image)
                .addOnSuccessListener {
                    ref.downloadUrl.addOnSuccessListener { imageUri ->
                        val uid = auth.currentUser?.uid!!
                        val uploadUser = UploadUser(
                            uid = uid,
                            name = register.name,
                            email = register.email,
                            password = register.password,
                            image = imageUri.toString()
                        )
                        fireStore.collection("users").document(uid).set(uploadUser)
                            .addOnSuccessListener {
                                uploadSuccess = true
                            }
                    }
                }.await()
            emit(uploadSuccess)
        }
    }
}