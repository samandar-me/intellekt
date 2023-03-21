package com.sdk.tafakkur.ui.auth.login

data class LoginState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val message: String = "",
    val successBarVisible: Boolean = false,
    val errorBarVisible: Boolean = false
)