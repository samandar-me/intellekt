package com.sdk.domain.use_case.base

import com.sdk.domain.use_case.auth.ChangeUseAuthStateUseCase
import com.sdk.domain.use_case.auth.LoginUseCase
import com.sdk.domain.use_case.auth.RegisterUseCase
import com.sdk.domain.use_case.main.GetQuestionListUseCase

data class UseCases(
    val loginUseCase: LoginUseCase,
    val registerUseCase: RegisterUseCase,
    val changeUseAuthStateUseCase: ChangeUseAuthStateUseCase,
    val getQuestionListUseCase: GetQuestionListUseCase
)