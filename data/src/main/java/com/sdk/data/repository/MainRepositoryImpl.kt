package com.sdk.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.sdk.domain.model.Question
import com.sdk.domain.repository.MainRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val firebaseFireStore: FirebaseFirestore
): MainRepository {
    override suspend fun getQuestionList(): Flow<List<Question>> = callbackFlow {
        val snap = firebaseFireStore.collection("questions")
            .addSnapshotListener { value, _ ->
                val questionList = value?.toObjects(Question::class.java)
                trySend(questionList ?: emptyList())
            }
        awaitClose {
            snap.remove()
        }
    }
}