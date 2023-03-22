package com.sdk.domain.repository

import com.sdk.domain.model.Login
import com.sdk.domain.model.Register
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun saveUserState(boolean: Boolean)
    suspend fun login(login: Login): Flow<Boolean>
    suspend fun register(register: Register): Flow<Boolean>
}