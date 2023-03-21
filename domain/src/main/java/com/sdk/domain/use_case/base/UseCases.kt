package com.sdk.domain.use_case.base

import com.sdk.domain.use_case.auth.LoginUseCase
import com.sdk.domain.use_case.auth.RegisterUseCase

data class UseCases(
    val loginUseCase: LoginUseCase,
    val registerUseCase: RegisterUseCase
)