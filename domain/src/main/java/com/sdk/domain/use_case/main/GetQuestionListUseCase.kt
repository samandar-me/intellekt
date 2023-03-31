package com.sdk.domain.use_case.main

import com.sdk.domain.model.Question
import com.sdk.domain.repository.MainRepository
import com.sdk.domain.use_case.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetQuestionListBaseUseCase = BaseUseCase<Unit,Flow<List<Question>>>

class GetQuestionListUseCase @Inject constructor(
    private val repository: MainRepository
): GetQuestionListBaseUseCase {
    override suspend fun invoke(parameter: Unit): Flow<List<Question>> {
        return repository.getQuestionList()
    }
}