package com.sdk.domain.use_case.auth

import com.sdk.domain.repository.AuthRepository
import com.sdk.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias ChangeUseAuthBaseStateUseCase = BaseUseCase<Boolean, Unit>

class ChangeUseAuthStateUseCase @Inject constructor(
    private val repository: AuthRepository
): ChangeUseAuthBaseStateUseCase {
    override suspend fun invoke(parameter: Boolean) {
        repository.saveUserState(parameter)
    }
}