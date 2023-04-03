package com.sdk.tafakkur.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.domain.model.Question
import com.sdk.domain.use_case.base.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _gameState: MutableStateFlow<GameState> = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> get() = _gameState

    private val questionList = mutableListOf<Question>()
    private var currentIndex = 1

    init {
        viewModelScope.launch {
            useCases.getQuestionListUseCase(Unit)
                .onStart {
                    _gameState.value = _gameState.value.copy(isLoading = true)
                }
                .catch {
                    _gameState.value =
                        _gameState.value.copy(isLoading = false, msg = "Xatolik yuz berdi.")
                }
                .collectLatest {
                    val question = it[0]
                    _gameState.value = _gameState.value.copy(
                        isLoading = false,
                        currentQuestion = question.question,
                        options = listOf(
                            question.opt1,
                            question.opt2,
                            question.opt3,
                            question.opt4
                        ),
                        correct = question.correct
                    )
                    questionList.addAll(it)
                }
        }
    }

    fun loadNextQuestion() {
        viewModelScope.launch {
            if (currentIndex <= questionList.lastIndex) {
                val question = questionList[currentIndex]
                _gameState.update {
                    GameState(
                        isEnabled = false,
                        currentQuestionNumber = currentIndex + 1,
                        currentQuestion = question.question,
                        options = listOf(question.opt1, question.opt2, question.opt3, question.opt3),
                        correct = question.correct,
                        score = _gameState.value.score
                    )
                }
                delay(2000L)
                _gameState.value = _gameState.value.copy(isEnabled = true)
                //currentIndex++
            }
        }
    }
}