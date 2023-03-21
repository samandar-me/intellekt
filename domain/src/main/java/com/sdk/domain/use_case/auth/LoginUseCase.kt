package com.sdk.domain.use_case.auth

import com.sdk.domain.model.Login
import com.sdk.domain.repository.AuthRepository
import com.sdk.domain.use_case.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias LoginBaseUseUseCase = BaseUseCase<Login, Flow<Boolean>>

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
): LoginBaseUseUseCase {
    override suspend fun invoke(parameter: Login): Flow<Boolean> {
        return repository.login(parameter)
    }
}