package com.sdk.tafakkur.ui.auth.register

import android.net.Uri

data class RegisterState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val message: String = "",
    val successBarVisible: Boolean = false,
    val errorBarVisible: Boolean = false,
    val image: Uri? = null
)