package com.sdk.domain.model

data class Question(
    val question: String = "",
    val opt1: String = "",
    val opt2: String = "",
    val opt3: String = "",
    val opt4: String = "",
    val correct: String = "",
    val id: Int = 0
)