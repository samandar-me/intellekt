package com.sdk.domain.repository

import com.sdk.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getQuestionList(): Flow<List<Question>>
}