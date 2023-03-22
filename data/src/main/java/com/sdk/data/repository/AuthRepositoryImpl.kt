package com.sdk.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.sdk.data.manager.DataStoreManager
import com.sdk.data.model.UploadUser
import com.sdk.domain.model.Login
import com.sdk.domain.model.Register
import com.sdk.domain.repository.AuthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val storage: FirebaseStorage,
    private val fireStore: FirebaseFirestore,
    private val dataStoreManager: DataStoreManager
) : AuthRepository {

    private var isSuccess = false

    override suspend fun saveUserState(boolean: Boolean) {
        dataStoreManager.saveAuthState(boolean)
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
            var imageUri =
                "https://firebasestorage.googleapis.com/v0/b/tafakkur-32f28.appspot.com/o/images%2Fistockphoto-1300845620-612x612.jpg?alt=media&token=e676c8a3-3be6-4f7c-a9a2-501e9cfaf522"
            if (register.image != null) {
                val fileName = UUID.randomUUID().toString()
                val ref = storage.getReference("images/$fileName")
                ref.putFile(register.image!!).await()
                imageUri = ref.downloadUrl.await().toString()
            }
            val uid = auth.currentUser?.uid!!
            val uploadUser = UploadUser(
                uid = uid,
                name = register.fullName,
                email = register.email,
                password = register.password,
                image = imageUri
            )
            fireStore.collection("users").document(uid).set(uploadUser)
                .addOnSuccessListener {
                    uploadSuccess = true
                }.await()
            emit(uploadSuccess)
        }
    }
}