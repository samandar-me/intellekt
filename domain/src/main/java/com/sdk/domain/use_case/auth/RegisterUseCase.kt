package com.sdk.domain.use_case.auth

import com.sdk.domain.model.Register
import com.sdk.domain.repository.AuthRepository
import com.sdk.domain.use_case.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias RegisterBaseUseCase = BaseUseCase<Register,Flow<Boolean>>

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
): RegisterBaseUseCase {
    override suspend fun invoke(parameter: Register): Flow<Boolean> {
        return repository.register(parameter)
    }
}