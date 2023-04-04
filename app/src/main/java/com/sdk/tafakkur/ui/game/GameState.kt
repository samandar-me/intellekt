package com.sdk.tafakkur.ui.game

data class GameState(
    val currentQuestionNumber: Int = 1,
    val currentQuestion: String = "",
    val options: List<String> = emptyList(),
    val correct: String = "",
    val isLoading: Boolean = false,
    val msg: String = "",
    val score: Int = 0,
    val isEnabled: Boolean = true
)